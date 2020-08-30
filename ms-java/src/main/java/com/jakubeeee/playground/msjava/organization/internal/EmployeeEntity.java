package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.IdentifiableEntity;
import com.jakubeeee.playground.msjava.organization.Position;

import javax.persistence.*;

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

    protected EmployeeEntity(String lastName, Position position, long salary, DepartmentEntity department) {
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.department = department;
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
