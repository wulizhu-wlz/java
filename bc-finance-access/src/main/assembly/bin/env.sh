cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
PROJECT_NAME=${PWD##*/}
CONF_DIR=$DEPLOY_DIR/conf

APP="access"
LOG_BASE="/opt/export/log/bc-finance"
LOG_DIR="$LOG_BASE/$APP"
