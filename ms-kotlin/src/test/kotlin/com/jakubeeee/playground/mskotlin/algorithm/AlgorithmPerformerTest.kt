package com.jakubeeee.playground.mskotlin.algorithm

import com.jakubeeee.playground.mskotlin.algorithm.AlgorithmPerformer.invokeLoop
import com.jakubeeee.playground.mskotlin.algorithm.AlgorithmPerformer.quickSortProvidedInts
import com.jakubeeee.playground.mskotlin.algorithm.AlgorithmPerformer.quickSortRandomInts
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue

internal class AlgorithmPerformerTest {

    @ParameterizedTest
    @CsvSource("-100", "-20", "-5", "-1", "0")
    fun invokeLoopTest_invalidIterations_shouldThrowException(iterations: Int) {
        val exception = assertFails { invokeLoop(iterations) }
        assert(exception is IllegalArgumentException)
    }

    @ParameterizedTest
    @CsvSource("1,1", "2,2", "5,5", "20,20", "100,100")
    fun invokeLoopTest_validIterations_shouldReturnProperIterationNumber(iterations: Int, expectedIterationsNumber: Int) {
        // when
        val resultingIterationsNumber: Int = invokeLoop(iterations)

        // then
        assertEquals(resultingIterationsNumber, expectedIterationsNumber)
    }

    @ParameterizedTest
    @CsvSource("-20", "-5", "-1", "0", "1")
    fun quickSortRandomIntsTest_invalidSize_shouldThrowException(size: Int) {
        val exception = assertFails { quickSortRandomInts(size) }
        assert(exception is IllegalArgumentException)
    }

    @ParameterizedTest
    @CsvSource("2", "5", "20", "50", "100")
    fun quickSortRandomIntsTest_validSize_shouldReturnSortedArray(size: Int) {
        // when
        val resultingSortedInts: IntArray = quickSortRandomInts(size)

        // then
        val expectedSortedInts: IntArray = resultingSortedInts.sortedArray()
        assertTrue(resultingSortedInts contentEquals expectedSortedInts)
    }

    @ParameterizedTest
    @MethodSource("quickSortProvidedInts_invalidArray_shouldThrowException_arguments")
    fun quickSortProvidedInts_invalidArray_shouldThrowException(unsortedInts: IntArray) {
        val exception = assertFails { quickSortProvidedInts(unsortedInts) }
        assert(exception is IllegalArgumentException)
    }

    @ParameterizedTest
    @MethodSource("quickSortProvidedInts_validArray_shouldReturnSortedArray_arguments")
    fun quickSortProvidedInts_validArray_shouldReturnSortedArray(unsortedInts: IntArray, expectedSortedInts: IntArray) {
        // when
        val resultingSortedInts: IntArray = quickSortProvidedInts(unsortedInts)

        // then
        assertTrue(resultingSortedInts contentEquals expectedSortedInts)
    }

    companion object {

        @JvmStatic
        @Suppress("unused")
        fun quickSortProvidedInts_invalidArray_shouldThrowException_arguments(): List<IntArray> {
            return listOf(intArrayOf(), intArrayOf(1))
        }

        @JvmStatic
        @Suppress("unused")
        fun quickSortProvidedInts_validArray_shouldReturnSortedArray_arguments(): List<Arguments> {
            return listOf(
                    Arguments.of(intArrayOf(2, 1), intArrayOf(1, 2)),
                    Arguments.of(intArrayOf(5, 3, 7, 1, 9), intArrayOf(1, 3, 5, 7, 9)),
                    Arguments.of(intArrayOf(-10, 5, -5, 10), intArrayOf(-10, -5, 5, 10)),
                    Arguments.of(intArrayOf(10, 9, 8, 7, 6, 5, 1, 2, 3, 4), intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                    Arguments.of(intArrayOf(-56, 235, -12, 46, 9, -16, -78, 68), intArrayOf(-78, -56, -16, -12, 9, 46, 68, 235))
            )
        }

    }

}