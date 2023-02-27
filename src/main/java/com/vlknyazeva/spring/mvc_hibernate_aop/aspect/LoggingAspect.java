package com.vlknyazeva.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.vlknyazeva.spring.mvc_hibernate_aop.repository.*.*(..))")
    //Прописав Joint Point в параметре метода Advice, мы получаем доступ к информации о сигнатуре и параметрах
    // метода с бизнес- логикой
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint point)
            throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Begin of" + methodName);

        Object targetMethodResult = point.proceed(); //при исп-ии аннотации around нужно запустить вышеописанный метод

        System.out.println("End of" + methodName);

        return targetMethodResult;
    }
}
