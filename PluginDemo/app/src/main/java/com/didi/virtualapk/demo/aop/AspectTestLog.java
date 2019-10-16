package com.didi.virtualapk.demo.aop;


import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author zhangchao on 2019-09-05.
 */

@Aspect
public class AspectTestLog {
    private static final String TAG = "AspectTestLog";

    @Before("execution(* *..MainActivity+.on**(..))")
    public void method(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getThis().getClass().getSimpleName();
        Log.e(TAG, "classname: " + className + "  method:" + signature.getName());
    }

    @Before("execution(* *..KaoLaWidget+.on**(..))")
    public void methodWidget(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getThis().getClass().getSimpleName();
        Log.e(TAG, "classname: " + className + "  method:" + signature.getName());
    }
}
