package com.jakubeeee.playground.common.jpa;

public interface EntityMapper<E extends JpaEntity, D extends DataContainer> {

    E toEntity(D dataContainer);

    D toDataContainer(E entity);

}
