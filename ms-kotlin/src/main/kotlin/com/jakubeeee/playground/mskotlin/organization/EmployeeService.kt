package com.jakubeeee.playground.mskotlin.organization

import com.jakubeeee.playground.mskotlin.organization.internal.EmployeeMapper
import com.jakubeeee.playground.mskotlin.organization.internal.EmployeeRepository
import org.springframework.stereotype.Service

@Service
open class EmployeeService(private val repository: EmployeeRepository) {

    fun getEmployee(lastName: String): Employee {
        val employeeEntity = repository.getOneByLastName(lastName)
        return EmployeeMapper.toDataContainer(employeeEntity)
    }

    fun getEmployees(projection: EmployeeProjection): List<Employee> {
        val (type, position, departmentName, managerName) = projection;
        return repository.findAll(type, position, departmentName, managerName)
                .map(EmployeeMapper::toDataContainer)
    }

}