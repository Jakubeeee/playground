package com.jakubeeee.playground.msjava.algorithm;

import com.jakubeeee.playground.common.durationmeasure.MeasureDuration;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

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
    public void invokeLoop(int iterations) {
        if (iterations < 1) throw new IllegalArgumentException("Iteration amount must be a positive number");
        for (int i = 1; i <= iterations; i++)
            logger.info("Iteration number: {}", i);
    }

    /**
     * Performs a quick sort of randomly generated int array.
     *
     * @param size the size of the int array to sort
     */
    @MeasureDuration
    public void quickSortRandomInts(int size) {
        if (size < 2) throw new IllegalArgumentException("Array size must be a at least 2");
        int[] unsortedInts = ThreadLocalRandom.current().ints(size, 0, 100000).toArray();
        quickSortFullIntArray(unsortedInts);
    }

    /**
     * Performs a quick sort of int array.
     *
     * @param unsortedInts the unsorted int array
     */
    @MeasureDuration
    public void quickSortProvidedInts(@NonNull int[] unsortedInts) {
        if (unsortedInts.length < 2) throw new IllegalArgumentException("Array size must be a at least 2");
        quickSortFullIntArray(unsortedInts);
    }

    private void quickSortFullIntArray(int[] unsortedInts) {
        int firstLowIndex = 0;
        int firstHighIndex = unsortedInts.length - 1;
        quickSortSubIntArray(unsortedInts, firstLowIndex, firstHighIndex);
        logger.info("Array after applying quick sort: {}", unsortedInts);
    }

    private void quickSortSubIntArray(int[] unsortedInts, int lowIndex, int highIndex) {
        final int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        final int middleInt = unsortedInts[middleIndex];
        int leftSideIndex = lowIndex;
        int rightSideIndex = highIndex;
        while (leftSideIndex <= rightSideIndex) {
            while (unsortedInts[leftSideIndex] < middleInt)
                leftSideIndex++;
            while (unsortedInts[rightSideIndex] > middleInt)
                rightSideIndex--;
            if (leftSideIndex <= rightSideIndex) {
                swapArrayElements(unsortedInts, leftSideIndex, rightSideIndex);
                leftSideIndex++;
                rightSideIndex--;
            }
        }
        if (lowIndex < rightSideIndex)
            quickSortSubIntArray(unsortedInts, lowIndex, rightSideIndex);
        if (highIndex > leftSideIndex)
            quickSortSubIntArray(unsortedInts, leftSideIndex, highIndex);
    }

    private void swapArrayElements(int[] array, int firstIndex, int secondIndex) {
        int firstElement = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = firstElement;
    }

}
