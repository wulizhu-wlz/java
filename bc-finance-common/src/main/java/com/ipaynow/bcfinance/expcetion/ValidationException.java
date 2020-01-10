package com.ipaynow.bcfinance.expcetion;

import com.ipaynow.bcfinance.enums.ExceptionEnum;

/**
 * @author ytw
 * @date 2019/6/20
 * description:
 */
public class ValidationException extends BaseException {

    public ValidationException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
