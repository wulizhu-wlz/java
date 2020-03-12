package com.ipaynow.bcfinance.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Wu
 * @date 2020-03-12 13:52
 */
public class MbsProxy<T> implements InvocationHandler {

    T t;

    public Object bind(T t) {
        this.t = t;
        Object instance = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), this);
        return instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
        Object invoke = method.invoke(t, args);
        System.out.println("代理后");
        return invoke;
    }
}
