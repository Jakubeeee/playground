package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.IdentifiableEntity;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static java.util.Objects.requireNonNull;

@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentEntity extends IdentifiableEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    protected DepartmentEntity() {
        // no-arg constructor required by the JPA
    }

    protected DepartmentEntity(@NotNull String name) {
        this.name = requireNonNull(name);
    }

    public String name() {
        return name;
    }

}
