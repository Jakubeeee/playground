package com.jakubeeee.playground.mskotlin.organization.internal

import com.jakubeeee.playground.mskotlin.organization.Position
import javax.persistence.*

@Entity
@Table(name = "WORKERS")
@DiscriminatorValue("WORKER")
open class WorkerEntity : EmployeeEntity {

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID", nullable = false)
    open var manager: ManagerEntity? = null
        protected set

    protected constructor()

    constructor(lastName: String, position: Position, salary: Long, department: DepartmentEntity, manager: ManagerEntity)
            : super(lastName, position, salary, department) {
        this.manager = manager
    }

}