package com.ipaynow.bcfinance.utils;

import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author wu
 * @createTime 2019/6/21
 */
public class ParamValidateUtil {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 参数校验
     *
     * @param request
     */
    public static void validate(Object request) {
        Set<ConstraintViolation<Object>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Object> violation : violations) {
                throw new BusinessException(ExceptionEnum.PARAM_ERROR);
            }
        }
    }

}