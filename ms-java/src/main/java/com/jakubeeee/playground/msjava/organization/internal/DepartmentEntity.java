package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.IdentifiableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentEntity extends IdentifiableEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    protected DepartmentEntity() {
        // no-arg constructor required by the JPA
    }

    public DepartmentEntity(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

}
