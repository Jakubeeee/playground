package com.jakubeeee.playground.mskotlin.organization.internal

import com.jakubeeee.playground.common.jpa.EntityMapper
import com.jakubeeee.playground.mskotlin.organization.BasicEmployeeInfo
import com.jakubeeee.playground.mskotlin.organization.Employee
import com.jakubeeee.playground.mskotlin.organization.Manager
import com.jakubeeee.playground.mskotlin.organization.Worker

object EmployeeMapper : EntityMapper<EmployeeEntity, Employee> {

    override fun toEntity(employee: Employee): EmployeeEntity {
        return when (employee) {
            is Manager -> toEntity(employee)
            is Worker -> toEntity(employee)
        }
    }

    fun toEntity(manager: Manager): ManagerEntity {
        val info = manager.basicEmployeeInfo
        return ManagerEntity(info.lastName, info.position, info.salary, DepartmentMapper.toEntity(info.department))
    }

    fun toEntity(worker: Worker): WorkerEntity {
        val info = worker.basicEmployeeInfo
        return WorkerEntity(info.lastName, info.position, info.salary, DepartmentMapper.toEntity(info.department), toEntity(worker.manager))
    }

    override fun toDataContainer(employeeEntity: EmployeeEntity): Employee {
        return when (employeeEntity) {
            is ManagerEntity -> toDataContainer(employeeEntity)
            is WorkerEntity -> toDataContainer(employeeEntity)
            else -> throw IllegalStateException("Employee type $employeeEntity is not supported")
        }
    }

    fun toDataContainer(managerEntity: ManagerEntity): Manager {
        return Manager(BasicEmployeeInfo(managerEntity.lastName!!, managerEntity.position!!, managerEntity.salary, DepartmentMapper.toDataContainer(managerEntity.department!!)))
    }

    fun toDataContainer(workerEntity: WorkerEntity): Worker {
        return Worker(BasicEmployeeInfo(workerEntity.lastName!!, workerEntity.position!!, workerEntity.salary, DepartmentMapper.toDataContainer(workerEntity.department!!)), toDataContainer(workerEntity.manager!!))
    }

}