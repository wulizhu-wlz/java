package com.ipaynow.bcfinance.expcetion;

import com.ipaynow.bcfinance.enums.ExceptionEnum;

/**
 * @author ytw
 * @date 2019/6/20
 * description:
 */
public abstract class BaseException extends RuntimeException {

    protected ExceptionEnum exceptionEnum;

    public BaseException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getDesc());
        this.exceptionEnum = exceptionEnum;
    }

    public String getCode(){
        return exceptionEnum.getCode();
    }

    public String getDesc(){
        return exceptionEnum.getDesc();
    }


}
