package com.jakubeeee.playground.common.jpa;

/**
 * Common interface for simple data carriers used primary as data transfer objects. Concrete implementations are usually {@link Record records}.
 * Can be mapped into {@link JpaEntity JPA entities} and vice versa using {@link EntityMapper entity mappers}.
 */
public interface DataContainer {}
