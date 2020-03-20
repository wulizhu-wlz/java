package com.ipaynow.bcfinance.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Wu
 * @date 2020-03-20 10:31
 */
@Target(ElementType.METHOD)//声明注解的作用域 类，方法，变量，构造器等
@Retention(RetentionPolicy.RUNTIME)//声明注解的声明周期 编译期间，.class文件，运行期
public @interface PermissionRequired {

    public String value();

}
