package ru.gb.FoodStore.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Замер времени выполнения каждого метода, находящихся в пакете ru.gb.FoodStore.service
 */
@Aspect
@Component
public class PerformanceAspect {
    @Around(value = "@annotation(TrackUserAction)")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();

    Object result = joinPoint.proceed(); // момент вызова основного метода

    long elapsedTime = System.currentTimeMillis() - start;
    System.out.println("Method " +
            joinPoint.getSignature().getName() +
            "Выполнился за " +
            elapsedTime +
            "миллисекунд");
    return result;
}
}
