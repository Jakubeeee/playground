package com.jakubeeee.playground.msjava.organization;

import org.jetbrains.annotations.NotNull;

import static java.util.Objects.requireNonNull;

public record Worker(@NotNull BasicEmployeeInfo basicEmployeeInfo,
                     @NotNull Manager manager) implements Employee {
    public Worker {
        requireNonNull(basicEmployeeInfo);
        requireNonNull(manager);
    }
}

