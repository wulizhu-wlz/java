package com.ipaynow.bcfinance.annotation;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wu
 * @date 2020-03-20 10:36
 */
public class PremissionInceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            PermissionRequired methodAnnotation = method.getMethodAnnotation(PermissionRequired.class);
            if (methodAnnotation != null){
                String value = methodAnnotation.value();
                System.out.println("拿到了自定义注解：" + methodAnnotation + ",value:" + value);
            }
        }
        return true;
    }
}
