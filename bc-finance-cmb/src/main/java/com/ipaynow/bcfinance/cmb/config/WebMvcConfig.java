package com.ipaynow.bcfinance.cmb.config;

import com.ipaynow.bcfinance.web.formatter.DateFormatter;
import com.ipaynow.bcfinance.web.interceptor.WebLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ytw
 * @date 2019/7/16
 * description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebLogInterceptor webLogInterceptor = new WebLogInterceptor();
        registry.addInterceptor(webLogInterceptor);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter());
    }
}
