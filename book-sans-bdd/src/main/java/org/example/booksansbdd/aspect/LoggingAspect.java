package org.example.booksansbdd.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.example.booksansbdd.service.*.*(..))")
    public void before() {
        System.out.println("Before Method");
    }

    @After("execution(* org.example.booksansbdd.service.*.*(..))")
    public void after (){
        System.out.println("After Method");
    }

}
