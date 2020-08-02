package com.jakubeeee.playground.msjava.algorithm;

import com.jakubeeee.playground.common.durationmeasure.MeasureDuration;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Contains implementations of various algorithms
 */
@Slf4j
@Service
public class AlgorithmService {

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
    public int[] quickSortProvidedInts(@NonNull int[] unsortedInts) {
        int[] sortedInts = AlgorithmPerformer.getInstance().quickSortProvidedInts(unsortedInts);
        logger.info("Array after applying quick sort: {}", sortedInts);
        return sortedInts;
    }

}
