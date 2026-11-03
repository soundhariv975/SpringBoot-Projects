package com.example.student.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.student.controller.*.*(..))")
    public void logBeforeMethod() {
        System.out.println("AOP: Student Controller method is called");
    }
}
