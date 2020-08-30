package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.IdentifiableEntity;
import com.jakubeeee.playground.msjava.organization.Position;

import javax.persistence.*;

@MappedSuperclass
public abstract class EmployeeEntity extends IdentifiableEntity {

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "POSITION")
    @Enumerated(value = EnumType.STRING)
    private Position position;

    @Column(name = "SALARY")
    private int salary;

    @ManyToOne
    private DepartmentEntity department;

    protected EmployeeEntity() {
        // no-arg constructor required by the JPA
    }

    protected EmployeeEntity(String lastName, Position position, int salary, DepartmentEntity department) {
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

    public int salary() {
        return salary;
    }

    public DepartmentEntity department() {
        return department;
    }

}
