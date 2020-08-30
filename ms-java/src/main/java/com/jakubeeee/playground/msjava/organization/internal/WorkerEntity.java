package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.msjava.organization.Position;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WORKERS")
public class WorkerEntity extends EmployeeEntity {

    @ManyToOne
    private ManagerEntity manager;

    protected WorkerEntity() {
        // no-arg constructor required by the JPA
    }

    public WorkerEntity(String lastName, Position position, int salary, DepartmentEntity department, ManagerEntity manager) {
        super(lastName, position, salary, department);
        this.manager = manager;
    }

    public ManagerEntity manager() {
        return manager;
    }

}
