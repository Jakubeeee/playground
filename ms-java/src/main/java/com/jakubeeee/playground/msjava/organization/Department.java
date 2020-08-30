package com.jakubeeee.playground.msjava.organization;

import org.jetbrains.annotations.NotNull;

import static java.util.Objects.requireNonNull;

public record Department(@NotNull String name) {
    public Department {
        requireNonNull(name);
    }
}
