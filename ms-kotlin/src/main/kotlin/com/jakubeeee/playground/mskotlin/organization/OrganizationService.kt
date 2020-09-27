package com.jakubeeee.playground.mskotlin.organization

import org.springframework.stereotype.Service

@Service
open class OrganizationService(private val employeeService: EmployeeService) {

    /**
     * Counts all persisted [employees][Employee] that match given [projection][EmployeeProjection].
     *
     * @param projection the projection tested against employees
     * @return the count of matching employees
     */
    fun countEmployees(projection: EmployeeProjection): Long {
        return countEmployees(employeeService.getEmployees(projection))
    }

    /**
     * Calculates salaries of all persisted [employees][Employee] that match given [projection][EmployeeProjection].
     *
     * @param projection the projection tested against employees
     * @return the cost of all matching employees
     */
    fun calculateEmployeeCost(projection: EmployeeProjection): Long {
        return calculateEmployeeCost(employeeService.getEmployees(projection))
    }

    private fun countEmployees(employees: List<Employee>): Long {
        return employees.size.toLong()
    }

    private fun calculateEmployeeCost(employees: List<Employee>): Long {
        return employees
                .map(Employee::basicEmployeeInfo)
                .map(BasicEmployeeInfo::salary)
                .sum()
    }

}