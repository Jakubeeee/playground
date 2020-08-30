package com.jakubeeee.playground.common.jpa;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

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
