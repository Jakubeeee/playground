package com.jakubeeee.playground.mskotlin.organization.internal

import com.jakubeeee.playground.common.jpa.IdentifiableEntity
import com.jakubeeee.playground.mskotlin.organization.Position
import javax.persistence.*

@Entity
@Table(name = "EMPLOYEES")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
abstract class EmployeeEntity protected constructor() : IdentifiableEntity() {

    @Column(name = "LAST_NAME", nullable = false)
    open var lastName: String? = null
        protected set

    @Column(name = "POSITION", nullable = false)
    @Enumerated(value = EnumType.STRING)
    open var position: Position? = null
        protected set

    @Column(name = "SALARY", nullable = false)
    open var salary: Long = 0
        protected set

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    open var department: DepartmentEntity? = null
        protected set

    @Column(name = "TYPE", nullable = false, insertable = false, updatable = false)
    protected open var type: String? = null

    constructor(lastName: String, position: Position, salary: Long, department: DepartmentEntity) : this() {
        this.lastName = lastName
        this.position = position
        this.salary = salary
        this.department = department
    }

}