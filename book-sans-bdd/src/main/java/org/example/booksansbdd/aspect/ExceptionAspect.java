package org.example.booksansbdd.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.example.booksansbdd.annotation.ExceptionHandler;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ExceptionAspect {

    /**
     * Log les exceptions des méthodes annotées avec @ExceptionHandler
     */
    @AfterThrowing(pointcut = "@annotation(exceptionHandler)", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception, ExceptionHandler exceptionHandler) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Exception dans la méthode : " + methodName);
        System.out.println("Message : " + exception.getMessage());
    }

}
