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
    open fun invokeLoop(iterations: Int): Int {
        val iterationsNumber: Int = AlgorithmPerformer.invokeLoop(iterations)
        logger.info("Loop iterations invoked: $iterationsNumber")
        return iterationsNumber
    }

    /**
     * Performs a quick sort of randomly generated int array.
     *
     * @param size the size of the int array to sort
     */
    @MeasureDuration
    open fun quickSortRandomInts(size: Int): IntArray {
        val sortedInts: IntArray = AlgorithmPerformer.quickSortRandomInts(size)
        logger.info("Array after applying quick sort: $sortedInts")
        return sortedInts
    }

    /**
     * Performs a quick sort of int array.
     *
     * @param unsortedInts the unsorted int array
     */
    @MeasureDuration
    open fun quickSortProvidedInts(unsortedInts: IntArray): IntArray {
        val sortedInts: IntArray = AlgorithmPerformer.quickSortProvidedInts(unsortedInts)
        logger.info("Array after applying quick sort: $sortedInts")
        return sortedInts
    }

}