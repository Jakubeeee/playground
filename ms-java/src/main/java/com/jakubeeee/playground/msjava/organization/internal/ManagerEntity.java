package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.msjava.organization.Position;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGERS")
public class ManagerEntity extends EmployeeEntity {

    protected ManagerEntity() {
        // no-arg constructor required by the JPA
    }

    public ManagerEntity(String lastName, Position position, int salary, DepartmentEntity department) {
        super(lastName, position, salary, department);
    }

}
