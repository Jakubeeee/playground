package com.jakubeeee.playground.mskotlin.organization.internal

import com.jakubeeee.playground.common.jpa.IdentifiableEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "DEPARTMENTS")
open class DepartmentEntity protected constructor() : IdentifiableEntity() {

    @Column(name = "NAME", nullable = false)
    open var name: String? = null
        protected set

    constructor(name: String) : this() {
        this.name = name
    }

}