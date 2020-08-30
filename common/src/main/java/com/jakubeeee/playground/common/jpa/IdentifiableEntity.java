package com.jakubeeee.playground.common.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdentifiableEntity implements JpaEntity {

    @Id
    @GeneratedValue
    private long id;

    public IdentifiableEntity() {
        // no-arg constructor required by the JPA
    }

    public long id() {
        return id;
    }

}
