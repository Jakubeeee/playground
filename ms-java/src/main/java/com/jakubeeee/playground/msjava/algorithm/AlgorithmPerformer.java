package com.jakubeeee.playground.msjava.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
class AlgorithmPerformer {

    private static final AlgorithmPerformer INSTANCE = new AlgorithmPerformer();

    static AlgorithmPerformer getInstance() {
        return INSTANCE;
    }

    private AlgorithmPerformer() {
    }

    int invokeLoop(int iterations) {
        if (iterations < 1) throw new IllegalArgumentException("Iteration amount must be a positive number");
        int iterationNumber = 0;
        for (int i = 1; i <= iterations; i++) {
            logger.debug("Iteration number: {}", i);
            iterationNumber++;
        }
        return iterationNumber;
    }

    int[] quickSortRandomInts(int size) {
        if (size < 2) throw new IllegalArgumentException("Array size must be a at least 2");
        int[] unsortedInts = ThreadLocalRandom.current().ints(size, 0, 100000).toArray();
        return quickSortFullIntArray(unsortedInts);
    }

    int[] quickSortProvidedInts(int[] unsortedInts) {
        if (unsortedInts.length < 2) throw new IllegalArgumentException("Array size must be a at least 2");
        return quickSortFullIntArray(unsortedInts);
    }

    private int[] quickSortFullIntArray(int[] unsortedInts) {
        int firstLowIndex = 0;
        int firstHighIndex = unsortedInts.length - 1;
        return quickSortSubIntArray(unsortedInts, firstLowIndex, firstHighIndex);
    }

    private int[] quickSortSubIntArray(int[] unsortedInts, int lowIndex, int highIndex) {
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
        return unsortedInts;
    }

    private void swapArrayElements(int[] array, int firstIndex, int secondIndex) {
        int firstElement = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = firstElement;
    }

}
