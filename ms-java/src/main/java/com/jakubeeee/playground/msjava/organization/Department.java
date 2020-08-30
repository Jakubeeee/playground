package com.jakubeeee.playground.msjava.organization;

import com.jakubeeee.playground.common.jpa.DataContainer;
import org.jetbrains.annotations.NotNull;

import static java.util.Objects.requireNonNull;

public record Department(@NotNull String name) implements DataContainer {
    public Department {
        requireNonNull(name);
    }
}
