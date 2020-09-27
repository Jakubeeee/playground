package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.IdentifiableEntity;
import com.jakubeeee.playground.msjava.organization.Position;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

import static java.util.Objects.requireNonNull;

@Entity
@Table(name = "EMPLOYEES")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public abstract class EmployeeEntity extends IdentifiableEntity {

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "POSITION", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Position position;

    @Column(name = "SALARY", nullable = false)
    private long salary;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    private DepartmentEntity department;

    @Column(name = "TYPE", nullable = false, insertable = false, updatable = false)
    private String type;

    protected EmployeeEntity() {
        // no-arg constructor required by the JPA
    }

    protected EmployeeEntity(@NotNull String lastName, @NotNull Position position, long salary, @NotNull DepartmentEntity department) {
        this.lastName = requireNonNull(lastName);
        this.position = requireNonNull(position);
        this.salary = salary;
        this.department = requireNonNull(department);
    }

    public String lastName() {
        return lastName;
    }

    public Position position() {
        return position;
    }

    public long salary() {
        return salary;
    }

    public DepartmentEntity department() {
        return department;
    }

}
