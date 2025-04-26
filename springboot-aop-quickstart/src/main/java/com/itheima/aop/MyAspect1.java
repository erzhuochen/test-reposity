package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MyAspect1 {

//    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
//    private void pt(){}
//
//
//
//    @Before("execution(* com.itheima.service.DeptService.*e*(java.lang.Integer))")
//    @Before("@annotation(com.itheima.anno.LogOperation)")

//    @Before("execution(* com.itheima.service.DeptService.list())")
//    public void before(JoinPoint joinPoint){
//        log.info("before....................");
//
//        Object target = joinPoint.getTarget();
//        log.info("获取目标对象：{}",target);
//
//        String className = joinPoint.getTarget().getClass().getName();
//        log.info("获取目标类：{}",className);
//
//        String methodName = joinPoint.getSignature().getName();
//        log.info("获取目标方法：{}",methodName);
//
//        Object[] args = joinPoint.getArgs();
//        log.info("获取目标方法参数：{}",Arrays.toString(args));
//    }

    @After("@annotation()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object result = proceedingJoinPoint.proceed();
        return result;
    }


}
