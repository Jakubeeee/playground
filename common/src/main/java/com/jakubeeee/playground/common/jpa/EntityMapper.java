package com.jakubeeee.playground.common.jpa;

/**
 * Maps {@link JpaEntity JPA entities} into {@link DataContainer data containers} and vice versa.
 *
 * @param <E> the JPA entity type
 * @param <D> the data container type
 */
public interface EntityMapper<E extends JpaEntity, D extends DataContainer> {

    E toEntity(D dataContainer);

    D toDataContainer(E entity);

}
