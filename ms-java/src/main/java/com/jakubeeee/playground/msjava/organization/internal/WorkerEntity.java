package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.msjava.organization.Position;

import javax.persistence.*;

@Entity
@Table(name = "WORKERS")
@DiscriminatorValue("WORKER")
public class WorkerEntity extends EmployeeEntity {

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID", nullable = false)
    private ManagerEntity manager;

    protected WorkerEntity() {
        // no-arg constructor required by the JPA
    }

    public WorkerEntity(String lastName, Position position, long salary, DepartmentEntity department, ManagerEntity manager) {
        super(lastName, position, salary, department);
        this.manager = manager;
    }

    public ManagerEntity manager() {
        return manager;
    }

}
