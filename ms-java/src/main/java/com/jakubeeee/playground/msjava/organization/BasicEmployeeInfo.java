package com.jakubeeee.playground.msjava.organization;

import org.jetbrains.annotations.NotNull;

import static java.util.Objects.requireNonNull;

public record BasicEmployeeInfo(
        @NotNull String lastName,
        @NotNull Position position,
        long salary,
        @NotNull Department department) {
    public BasicEmployeeInfo {
        requireNonNull(lastName);
        requireNonNull(position);
        requireNonNull(department);
    }
}