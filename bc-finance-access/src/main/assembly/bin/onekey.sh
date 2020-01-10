#!/bin/bash

PROJECT_DIR=/opt/export/app/code/bc-finance
DEPLOY_DIR=/opt/export/app/bc-finance
DEPLOY_FILE_NAME='bc-finance-access-1.0.0-SNAPSHOT.jar'
PACKAGE_FILE_NAME=bc-finance-access-assembly.tar.gz
TARGET_PATH=bc-finance-access/target
BRANCH=$1
DEPLOY_CONTRACT=$2
PROFILE=$DEFAULT_PROFILE

if [ -z "$BRANCH" ]; then
    echo "未指定需要打包的git分支"
    exit 1
fi
if [ -z "$DEPLOY_CONTRACT" ]; then
    echo "未指定需要部署的合约，none为不需要部署合约"
    exit 1
fi
if [ -n "$3" ]; then
    PROFILE=$3
fi
cd $PROJECT_DIR

git checkout $BRANCH
git pull

mvn clean package -Dmaven.test.skip=true -P$PROFILE -X -f pom.xml

cd $DEPLOY_DIR
if [ -e pre-$PACKAGE_FILE_NAME ]; then
    rm -rf pre-$PACKAGE_FILE_NAME
fi
if [ -e $PACKAGE_FILE_NAME ]; then
    mv $PACKAGE_FILE_NAME pre-$PACKAGE_FILE_NAME
fi

cp $PROJECT_DIR/$TARGET_PATH/$PACKAGE_FILE_NAME ./

PS_INFO=$(ps -ef | grep $DEPLOY_FILE_NAME | grep -v grep)
echo $PS_INFO
if [ -n "$PS_INFO" ]; then
    PID=$(echo $PS_INFO | awk '{print $2}')
    kill $PID
    for (( VAR = 0; VAR < 10; ++VAR )); do
        echo "...................."
        sleep 1
    done

    PS_INFO=$(ps -ef | grep $DEPLOY_FILE_NAME | grep -v grep)
    if [ -n "$PS_INFO" ]; then
        echo "进程关闭失败，强制关闭"
        echo $PS_INFO
        PID=$(echo $PS_INFO | awk '{print $2}')
        kill -9 $PID
    fi
fi

rm -rf bc-finance-access
tar -zxvf $PACKAGE_FILE_NAME
JAVA_MEM_OPTS="-server -Xms512m -Xmx512m -Xmn256m -Xss256k -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:+DisableExplicitGC -XX:LargePageSizeInBytes=128m"
nohup java -Dcontract=$DEPLOY_CONTRACT $JAVA_MEM_OPTS -jar bc-finance-access/lib/$DEPLOY_FILE_NAME > stdout.log 2>&1 &
