package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.msjava.organization.Position;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

import static java.util.Objects.requireNonNull;

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

    protected WorkerEntity(@NotNull String lastName, @NotNull Position position, long salary, @NotNull DepartmentEntity department, @NotNull ManagerEntity manager) {
        super(requireNonNull(lastName), requireNonNull(position), salary, requireNonNull(department));
        this.manager = requireNonNull(manager);
    }

    public ManagerEntity manager() {
        return manager;
    }

}
