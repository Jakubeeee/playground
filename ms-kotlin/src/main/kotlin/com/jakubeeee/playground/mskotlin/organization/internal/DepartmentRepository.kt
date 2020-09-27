package com.jakubeeee.playground.mskotlin.organization.internal

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository : JpaRepository<DepartmentEntity, Long> {

    fun getOneByName(name: String): DepartmentEntity

}