package com.zpeng.intercept.Impl;

import com.zpeng.intercept.Interceptor;
import com.zpeng.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public class InterceptorImpl implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before ...");
        return false;
    }

    @Override
    public void after() {
        System.out.println("after ...");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around ... 1");
        Object obj = invocation.proceed();
        System.out.println("around ... 2");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning ...");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing ...");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
