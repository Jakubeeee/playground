package com.jakubeeee.playground.msjava.algorithm;

import com.jakubeeee.playground.common.durationmeasure.MeasureDuration;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Contains implementations of various algorithms
 */
@Service
public class AlgorithmService {

    private static final Logger logger = getLogger(AlgorithmService.class);

    /**
     * Invokes a simple for loop.
     *
     * @param iterations the amount of loop iterations to perform
     */
    @MeasureDuration
    public int invokeLoop(int iterations) {
        int iterationsNumber = AlgorithmPerformer.getInstance().invokeLoop(iterations);
        logger.info("Loop iterations invoked: {}", iterationsNumber);
        return iterationsNumber;
    }

    /**
     * Performs a quick sort of randomly generated int array.
     *
     * @param size the size of the int array to sort
     */
    @MeasureDuration
    public int[] quickSortRandomInts(int size) {
        int[] sortedInts = AlgorithmPerformer.getInstance().quickSortRandomInts(size);
        logger.info("Array after applying quick sort: {}", sortedInts);
        return sortedInts;
    }

    /**
     * Performs a quick sort of int array.
     *
     * @param unsortedInts the unsorted int array
     */
    @MeasureDuration
    public int[] quickSortProvidedInts(int @NotNull [] unsortedInts) {
        int[] sortedInts = AlgorithmPerformer.getInstance().quickSortProvidedInts(unsortedInts);
        logger.info("Array after applying quick sort: {}", sortedInts);
        return sortedInts;
    }

}
