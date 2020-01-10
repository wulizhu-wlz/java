package com.ipaynow.bcfinance.interceptor;

import com.ipaynow.bcfinance.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author ytw
 * @date 2019/6/19
 * description:
 */
public class WebLogInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(WebLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ipAddress = IpUtil.getIpAddress(request);
        MDC.put("TRACE_ID", UUID.randomUUID().toString().replace("-", ""));
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            logger.info("统一日志打印, 请求ip={}, controller={}, method={}", ipAddress, handlerMethod.getBeanType().getName(), handlerMethod.getMethod().getName());
        }else{
            logger.info("统一日志打印, 请求ip={}", ipAddress);
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove("TRACE_ID");
    }
}
