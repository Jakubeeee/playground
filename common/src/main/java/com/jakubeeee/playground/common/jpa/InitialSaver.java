package com.jakubeeee.playground.common.jpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Template for spring components that are activated during application startup and are responsible to persist initial data into a database.
 * Each initial saver is responsible for persisting entities of one type using it's repository.
 *
 * @param <E> the JPA entity type
 * @param <R> the Spring Data JPA repository type
 * @implSpec implementations should be annotated with spring's {@link Component} in order to be activated.
 */
public abstract class InitialSaver<E extends JpaEntity, R extends JpaRepository<E, Long>> implements ApplicationRunner {

    private final R repository;

    public InitialSaver(R repository) {
        this.repository = repository;
    }

    @Override
    public final void run(ApplicationArguments args) {
        initialEntities().forEach(repository::save);
    }

    protected abstract Stream<E> initialEntities();

}
