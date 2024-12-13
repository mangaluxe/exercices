package org.example.booksansbdd.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.example.booksansbdd.annotation.Log;



@Aspect
@Component
public class LoggingAspect {

    /**
     * Avant les méthodes annotées avec @Log
     */
    @Before("@annotation(log)")
    public void before(JoinPoint joinPoint, Log log) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("----- Entrée dans la méthode : " + methodName);
    }


    /**
     * Après les méthodes annotées avec @Log
     */
    @After("@annotation(log)")
    public void after(JoinPoint joinPoint, Log log) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("----- Sortie de la méthode : " + methodName + " -----");
    }

}
