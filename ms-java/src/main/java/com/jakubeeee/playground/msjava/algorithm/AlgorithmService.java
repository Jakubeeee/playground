package com.jakubeeee.playground.msjava.algorithm;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class AlgorithmService {

    /**
     * Invokes a simple for loop.
     *
     * @param iterations the amount of loop iterations to perform
     */
    public void invokeLoop(int iterations) {
        if (iterations < 1) throw new IllegalArgumentException("Iteration amount must be positive");
        var startingInstant = Instant.now();
        for (int i = 1; i <= iterations; i++)
            LOGGER.info("Iteration number: {}", i);
        var endingInstant = Instant.now();
        var methodDuration = Duration.between(startingInstant, endingInstant);
        LOGGER.info("Invoke loop method duration: {}", methodDuration.toMillis());
    }

    /**
     * Performs a quick sort of randomly generated int array.
     *
     * @param amount the size of the int array to sort
     */
    public void quickSortRandomInts(int amount) {
        int[] unsortedInts = ThreadLocalRandom.current().ints(amount, 0, 100000).toArray();
        quickSort(unsortedInts);
    }

    /**
     * Performs a quick sort of int array.
     *
     * @param unsortedInts the unsorted int array
     */
    public void quickSort(@NonNull int[] unsortedInts) {
        LOGGER.info("Array before applying quick sort: {}", unsortedInts);
        var startingInstant = Instant.now();
        int firstLowIndex = 0; // the index of the first array element
        int firstHighIndex = unsortedInts.length - 1; // the index of the las array element
        quickSortSubArray(unsortedInts, firstLowIndex, firstHighIndex);
        var endingInstant = Instant.now();
        var methodDuration = Duration.between(startingInstant, endingInstant);
        LOGGER.info("Quick sort method duration: {}", methodDuration.toMillis());
        LOGGER.info("Array after applying quick sort: {}", unsortedInts);
    }

    private void quickSortSubArray(int[] unsortedInts, int lowIndex, int highIndex) {
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        int middleInt = unsortedInts[middleIndex];
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
            quickSortSubArray(unsortedInts, lowIndex, rightSideIndex);
        if (highIndex > leftSideIndex)
            quickSortSubArray(unsortedInts, leftSideIndex, highIndex);
    }

    private void swapArrayElements(int[] array, int firstIndex, int secondIndex) {
        int firstElement = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = firstElement;
    }

}
