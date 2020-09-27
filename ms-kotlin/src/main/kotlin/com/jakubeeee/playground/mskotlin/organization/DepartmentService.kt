package com.jakubeeee.playground.mskotlin.organization

import com.jakubeeee.playground.mskotlin.organization.internal.DepartmentMapper
import com.jakubeeee.playground.mskotlin.organization.internal.DepartmentRepository
import org.springframework.stereotype.Service

@Service
open class DepartmentService(private val repository: DepartmentRepository) {

    fun getDepartment(name: String): Department {
        val departmentEntity = repository.getOneByName(name)
        return DepartmentMapper.toDataContainer(departmentEntity)
    }

}