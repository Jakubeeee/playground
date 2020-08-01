package com.jakubeeee.playground.msjava.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static java.util.Arrays.stream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlgorithmPerformerTest {

    private final AlgorithmPerformer algorithmPerformer = AlgorithmPerformer.getInstance();

    @ParameterizedTest
    @CsvSource({"-100", "-20", "-5", "-1", "0"})
    void invokeLoopTest_invalidIterations_shouldThrowException(int iterations) {
        assertThrows(
                IllegalArgumentException.class,
                () -> algorithmPerformer.invokeLoop(iterations));
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "5,5", "20,20", "100,100"})
    void invokeLoopTest_validIterations_shouldReturnProperIterationNumber(int iterations, int expectedIterationsNumber) {
        // when
        int resultingIterationsNumber = algorithmPerformer.invokeLoop(iterations);

        // then
        assertThat(resultingIterationsNumber, is(equalTo(expectedIterationsNumber)));
    }

    @ParameterizedTest
    @CsvSource({"-20", "-5", "-1", "0", "1"})
    void quickSortRandomIntsTest_invalidSize_shouldThrowException(int size) {
        assertThrows(
                IllegalArgumentException.class,
                () -> algorithmPerformer.quickSortRandomInts(size));
    }

    @ParameterizedTest
    @CsvSource({"2", "5", "20", "50", "100"})
    void quickSortRandomIntsTest_validSize_shouldReturnSortedArray(int size) {
        // when
        int[] resultingSortedInts = algorithmPerformer.quickSortRandomInts(size);

        // then
        int[] expectedSortedInts = stream(resultingSortedInts).sorted().toArray();
        assertThat(resultingSortedInts, is(equalTo(expectedSortedInts)));
    }

    @ParameterizedTest
    @NullSource
    void quickSortProvidedInts_nullArray_shouldThrowException(int[] unsortedInts) {
        assertThrows(
                NullPointerException.class,
                () -> algorithmPerformer.quickSortProvidedInts(unsortedInts));
    }

    @ParameterizedTest
    @MethodSource("quickSortProvidedInts_invalidArray_shouldThrowException_arguments")
    void quickSortProvidedInts_invalidArray_shouldThrowException(int[] unsortedInts) {
        assertThrows(
                IllegalArgumentException.class,
                () -> algorithmPerformer.quickSortProvidedInts(unsortedInts));
    }

    static List<int[]> quickSortProvidedInts_invalidArray_shouldThrowException_arguments() {
        return List.of(
                new int[]{},
                new int[]{1}
        );
    }

    @ParameterizedTest
    @MethodSource("quickSortProvidedInts_validArray_shouldReturnSortedArray_arguments")
    void quickSortProvidedInts_validArray_shouldReturnSortedArray(int[] unsortedInts, int[] expectedSortedInts) {
        // when
        int[] resultingSortedInts = algorithmPerformer.quickSortProvidedInts(unsortedInts);

        // then
        assertThat(resultingSortedInts, is(equalTo(expectedSortedInts)));
    }

    static List<Arguments> quickSortProvidedInts_validArray_shouldReturnSortedArray_arguments() {
        return List.of(
                Arguments.of(new int[]{2, 1}, new int[]{1, 2}),
                Arguments.of(new int[]{5, 3, 7, 1, 9}, new int[]{1, 3, 5, 7, 9}),
                Arguments.of(new int[]{-10, 5, -5, 10}, new int[]{-10, -5, 5, 10}),
                Arguments.of(new int[]{10, 9, 8, 7, 6, 5, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),
                Arguments.of(new int[]{-56, 235, -12, 46, 9, -16, -78, 68}, new int[]{-78, -56, -16, -12, 9, 46, 68, 235})
        );
    }

}
