package com.jakubeeee.playground.common.durationmeasure;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * Logs the execution duration of methods annotated with {@link MeasureDuration}. Can be used as a very simple and not
 * particularly reliable performance measurement tool.
 */
@Slf4j
@Aspect
@Component
public class DurationMeasureAspect {

    @Around("@annotation(com.jakubeeee.playground.common.durationmeasure.MeasureDuration)")
    public Object aroundTaskExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        var startingInstant = Instant.now();
        Object returnValue = joinPoint.proceed();
        var endingInstant = Instant.now();
        var methodDuration = Duration.between(startingInstant, endingInstant);
        logger.info("\"{}\" method duration: \"{}\" millis", joinPoint.getSignature().getName(),
                methodDuration.toMillis());
        return returnValue;
    }

}
