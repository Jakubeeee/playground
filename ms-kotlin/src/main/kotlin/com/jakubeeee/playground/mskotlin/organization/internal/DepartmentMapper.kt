package com.jakubeeee.playground.mskotlin.organization.internal

import com.jakubeeee.playground.common.jpa.EntityMapper
import com.jakubeeee.playground.mskotlin.organization.Department

object DepartmentMapper : EntityMapper<DepartmentEntity, Department> {

    override fun toEntity(dataContainer: Department): DepartmentEntity {
        return DepartmentEntity(dataContainer.name)
    }

    override fun toDataContainer(entity: DepartmentEntity): Department {
        return Department(entity.name!!)
    }

}