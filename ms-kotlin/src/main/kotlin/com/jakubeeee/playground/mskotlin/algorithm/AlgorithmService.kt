package com.jakubeeee.playground.mskotlin.algorithm

import com.jakubeeee.playground.common.durationmeasure.MeasureDuration
import mu.KotlinLogging
import org.springframework.stereotype.Service

/**
 * Contains implementations of various algorithms
 */
@Service
open class AlgorithmService {

    companion object {
        private val logger = KotlinLogging.logger {}
    }

    /**
     * Invokes a simple for loop.
     *
     * @param iterations the amount of loop iterations to perform
     */
    @MeasureDuration
    open fun invokeLoop(iterations: Int) {
        require(iterations >= 1) { "Iteration amount must be a positive number" }
        for (i in 1..iterations)
            logger.info { "Iteration number: $i" }
    }

    @MeasureDuration
    open fun quickSortRandomInts(size: Int) {
        require(size >= 2) { "Array size must be a at least 2" }
        val unsortedInts: IntArray = (1..size).map { (0..100000).random() }.toIntArray()
        quickSortFullIntArray(unsortedInts)
    }

    /**
     * Performs a quick sort of int array.
     *
     * @param unsortedInts the unsorted int array
     */
    @MeasureDuration
    open fun quickSortProvidedInts(unsortedInts: IntArray) {
        require(unsortedInts.size >= 2) { "Array size must be a at least 2" }
        quickSortFullIntArray(unsortedInts)
    }

    private fun quickSortFullIntArray(unsortedInts: IntArray) {
        val firstLowIndex = 0
        val firstHighIndex = unsortedInts.size - 1
        quickSortSubIntArray(unsortedInts, firstLowIndex, firstHighIndex)
        logger.info { "Array after applying quick sort: ${unsortedInts.contentToString()}" }
    }

    private fun quickSortSubIntArray(unsortedInts: IntArray, lowIndex: Int, highIndex: Int) {
        val middleIndex = lowIndex + (highIndex - lowIndex) / 2
        val middleInt = unsortedInts[middleIndex]
        var leftSideIndex = lowIndex
        var rightSideIndex = highIndex
        while (leftSideIndex <= rightSideIndex) {
            while (unsortedInts[leftSideIndex] < middleInt)
                leftSideIndex++
            while (unsortedInts[rightSideIndex] > middleInt)
                rightSideIndex--
            if (leftSideIndex <= rightSideIndex) {
                swapArrayElements(unsortedInts, leftSideIndex, rightSideIndex)
                leftSideIndex++
                rightSideIndex--
            }
        }
        if (lowIndex < rightSideIndex)
            quickSortSubIntArray(unsortedInts, lowIndex, rightSideIndex)
        if (highIndex > leftSideIndex)
            quickSortSubIntArray(unsortedInts, leftSideIndex, highIndex)
    }

    private fun swapArrayElements(array: IntArray, firstIndex: Int, secondIndex: Int) {
        val firstElement = array[firstIndex]
        array[firstIndex] = array[secondIndex]
        array[secondIndex] = firstElement
    }

}