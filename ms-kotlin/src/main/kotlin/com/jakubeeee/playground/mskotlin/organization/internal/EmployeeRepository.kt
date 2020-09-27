package com.jakubeeee.playground.mskotlin.organization.internal

import com.jakubeeee.playground.mskotlin.organization.Position
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<EmployeeEntity, Long> {

    fun getOneByLastName(lastName: String): EmployeeEntity

    @Query("""
             SELECT e FROM EmployeeEntity e 
                 WHERE (e IN (SELECT m from ManagerEntity m) OR e IN (SELECT w from WorkerEntity w WHERE (:managerName IS NULL OR w.manager.lastName = :managerName)))
                 AND (:type IS NULL OR e.type = :type) 
                 AND (:position IS NULL OR e.position = :position)
                 AND (:departmentName IS NULL OR e.department.name = :departmentName)
            """
    )
    fun findAll(@Param("type") type: String?,
                @Param("position") position: Position?,
                @Param("departmentName") departmentName: String?,
                @Param("managerName") managerName: String?)
            : Set<EmployeeEntity>

}