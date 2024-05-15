package ru.gb.FoodStore.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Логирование вызова всех методов, находящихся в пакете ru.gb.FoodStore.service
 */
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* ru.gb.FoodStore.service.*.*(..))")
    public void logBeforeMethodCall(JoinPoint joinPoint){
        System.out.println("Метод " + joinPoint.getSignature().getName() + " был вызван");
    }
}
