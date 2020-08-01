package com.jakubeeee.playground.mskotlin.algorithm

import mu.KotlinLogging

internal object AlgorithmPerformer {

    private val logger = KotlinLogging.logger {}

    fun invokeLoop(iterations: Int): Int {
        require(iterations >= 1) { "Iteration amount must be a positive number" }
        var iterationNumber = 0
        for (i in 1..iterations) {
            logger.debug { "Iteration number: $i" }
            iterationNumber++
        }
        return iterationNumber
    }

    fun quickSortRandomInts(size: Int): IntArray {
        require(size >= 2) { "Array size must be a at least 2" }
        val unsortedInts: IntArray = (1..size).map { (0..100000).random() }.toIntArray()
        return quickSortFullIntArray(unsortedInts)
    }

    fun quickSortProvidedInts(unsortedInts: IntArray): IntArray {
        require(unsortedInts.size >= 2) { "Array size must be a at least 2" }
        return quickSortFullIntArray(unsortedInts)
    }

    private fun quickSortFullIntArray(unsortedInts: IntArray): IntArray {
        val firstLowIndex = 0
        val firstHighIndex = unsortedInts.size - 1
        return quickSortSubIntArray(unsortedInts, firstLowIndex, firstHighIndex)
    }

    private fun quickSortSubIntArray(unsortedInts: IntArray, lowIndex: Int, highIndex: Int): IntArray {
        val middleIndex = lowIndex + (highIndex - lowIndex) / 2
        val middleInt = unsortedInts[middleIndex]
        var leftSideIndex = lowIndex
        var rightSideIndex = highIndex
        while (leftSideIndex <= rightSideIndex) {
            while (unsortedInts[leftSideIndex] < middleInt) leftSideIndex++
            while (unsortedInts[rightSideIndex] > middleInt) rightSideIndex--
            if (leftSideIndex <= rightSideIndex) {
                swapArrayElements(unsortedInts, leftSideIndex, rightSideIndex)
                leftSideIndex++
                rightSideIndex--
            }
        }
        if (lowIndex < rightSideIndex) quickSortSubIntArray(unsortedInts, lowIndex, rightSideIndex)
        if (highIndex > leftSideIndex) quickSortSubIntArray(unsortedInts, leftSideIndex, highIndex)
        return unsortedInts
    }

    private fun swapArrayElements(array: IntArray, firstIndex: Int, secondIndex: Int) {
        val firstElement = array[firstIndex]
        array[firstIndex] = array[secondIndex]
        array[secondIndex] = firstElement
    }

}