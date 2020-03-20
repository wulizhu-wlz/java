package com.ipaynow.bcfinance.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ipaynow.bcfinance.annotation.PremissionInceptor;
import com.ipaynow.bcfinance.expcetion.BaseException;
import com.ipaynow.bcfinance.interceptor.WebLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * @author ytw
 * @date 2019/6/19
 * description:
 */
@Configuration
@ControllerAdvice
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebLogInterceptor webLogInterceptor = new WebLogInterceptor();
        PremissionInceptor premissionInceptor = new PremissionInceptor();
        registry.addInterceptor(webLogInterceptor);
        registry.addInterceptor(premissionInceptor);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptionHandlerMethod(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        JSONObject result = new JSONObject();
        if (ex instanceof BaseException) {
            BaseException baseException = (BaseException) ex;
            result.put("msg", baseException.getDesc());
        } else {
            result.put("msg", "系统异常");
        }
        return result.toJSONString();
    }
}
