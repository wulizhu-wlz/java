package com.ipaynow.bcfinance.expcetion;

import com.ipaynow.bcfinance.enums.ExceptionEnum;

/**
 * @author ytw
 * @date 2019/6/20
 * description:
 */
public class BusinessException extends BaseException   {


    public BusinessException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }



}
