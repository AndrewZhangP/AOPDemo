package com.zpeng.aspect;

import com.zpeng.validator.UserValidator;
import com.zpeng.validator.impl.UserValidatorImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    @DeclareParents(value = "com.zpeng.service.impl.UserServiceImpl",defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.zpeng.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before ...");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after ...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning ...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing ...");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("around before ...");
        jp.proceed();
        System.out.println("around after ...");
    }


}
