package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.msjava.organization.Position;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGERS")
@DiscriminatorValue("MANAGER")
public class ManagerEntity extends EmployeeEntity {

    protected ManagerEntity() {
        // no-arg constructor required by the JPA
    }

    public ManagerEntity(String lastName, Position position, long salary, DepartmentEntity department) {
        super(lastName, position, salary, department);
    }

}
