package org.example.booksansbdd.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.booksansbdd.annotation.Performance;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class PerformanceAspect {

    /**
     * Mesure le temps d'exécution des méthodes annotées avec @Performance
     */
    @Around("@annotation(performance)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, Performance performance) throws Throwable {
        // long startTime = System.currentTimeMillis();
        long startTime = System.nanoTime(); // Début
        try {
            System.out.println("Méthode interceptée : " + proceedingJoinPoint.getSignature().getName());
            return proceedingJoinPoint.proceed();
        }
        catch (Throwable e) {
            throw new RuntimeException("Erreur dans PerformanceAspect : " + e.getMessage());
        }
        finally {
            // long endTime = System.currentTimeMillis();
            long endTime = System.nanoTime(); // Fin
            System.out.println("Temps d'exécution : " + (endTime - startTime) + " nanosec");
        }
    }

}
