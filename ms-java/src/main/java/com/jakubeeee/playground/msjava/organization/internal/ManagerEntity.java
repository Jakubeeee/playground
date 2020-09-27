package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.msjava.organization.Position;
import org.jetbrains.annotations.NotNull;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import static java.util.Objects.requireNonNull;

@Entity
@Table(name = "MANAGERS")
@DiscriminatorValue("MANAGER")
public class ManagerEntity extends EmployeeEntity {

    protected ManagerEntity() {
        // no-arg constructor required by the JPA
    }

    protected ManagerEntity(@NotNull String lastName, @NotNull Position position, long salary, @NotNull DepartmentEntity department) {
        super(requireNonNull(lastName), requireNonNull(position), salary, requireNonNull(department));
    }

}
