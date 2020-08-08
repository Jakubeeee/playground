package com.jakubeeee.playground.common.collectors;

import java.util.stream.Collector;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public final class CustomCollectors {

    private CustomCollectors() {
        throw new UnsupportedOperationException();
    }

    public static <T> Collector<T, ?, T> toSingleton() {
        return collectingAndThen(
                toList(),
                list -> {
                    if (list.size() != 1)
                        throw new IllegalStateException("Exactly one element must be present in the stream");
                    return list.get(0);
                }
        );
    }

}
