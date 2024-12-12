package org.example.booksansbdd.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* org.example.booksansbdd.service.*.*(..))")
    public Object around (ProceedingJoinPoint proceedingJoinPoint) {

        try {
            System.out.println("Around cut"); // Log avant l'exécution de la méthode

            Object[] args = proceedingJoinPoint.getArgs(); // Récupère les arguments passés à la méthode interceptée
            System.out.println(args);

            Object result = proceedingJoinPoint.proceed(); // Exécute la méthode originale et récupère son résultat
            return result;

        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }
        finally {
            return null;
        }

    }





}
