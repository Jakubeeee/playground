package com.jakubeeee.playground.msjava.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Service
public class AlgorithmService {

    public void invokeLoop(int iterations) {
        var startingInstant = Instant.now();
        for (int i = 1; i <= iterations; i++)
            LOGGER.info("Iteration number: {}", i);
        var endingInstant = Instant.now();
        var methodDuration = Duration.between(startingInstant, endingInstant);
        LOGGER.info("Invoke loop method duration: {}", methodDuration.toMillis());
    }

}
