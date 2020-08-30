package com.jakubeeee.playground.msjava.organization;

import org.jetbrains.annotations.NotNull;

import static java.util.Objects.requireNonNull;

public record Manager(@NotNull BasicEmployeeInfo basicEmployeeInfo) implements Employee {
    public Manager {
        requireNonNull(basicEmployeeInfo);
    }
}