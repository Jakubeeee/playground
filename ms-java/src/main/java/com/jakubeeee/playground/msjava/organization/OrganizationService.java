package com.jakubeeee.playground.msjava.organization;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class OrganizationService {

    private final EmployeeService employeeService;

    @Autowired
    public OrganizationService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public long countEmployees(@Nullable String type, @Nullable Position position, @Nullable String departmentName, @Nullable String managerName) {
        return countEmployees(employeeService.getEmployees(type, position, departmentName, managerName));
    }

    public long calculateEmployeeCost(@Nullable String type, @Nullable Position position, @Nullable String departmentName, @Nullable String managerName) {
        return calculateEmployeeCost(employeeService.getEmployees(type, position, departmentName, managerName));
    }

    private long countEmployees(Stream<Employee> employees) {
        return employees.count();
    }

    private long calculateEmployeeCost(Stream<Employee> employees) {
        return employees
                .map(Employee::basicEmployeeInfo)
                .mapToLong(BasicEmployeeInfo::salary)
                .reduce(0L, Long::sum);
    }

}
