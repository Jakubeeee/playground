package com.jakubeeee.playground.mskotlin.organization.internal

import com.jakubeeee.playground.mskotlin.organization.Position
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "MANAGERS")
@DiscriminatorValue("MANAGER")
open class ManagerEntity : EmployeeEntity {

    protected constructor()

    constructor(lastName: String, position: Position, salary: Long, department: DepartmentEntity)
            : super(lastName, position, salary, department)

}