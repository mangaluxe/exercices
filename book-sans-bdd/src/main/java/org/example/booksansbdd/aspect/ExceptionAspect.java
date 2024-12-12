package org.example.booksansbdd.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ExceptionAspect {

    @AfterThrowing(pointcut = "execution(* org.example.booksansbdd.service.BookService.*(..))", throwing = "exception")
    public void afterThrowing (Exception exception) {
        System.out.println("Une exception a été levée : " + exception.getMessage());
    }

}
