package com.jakubeeee.playground.msjava.organization;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

@Service
public class OrganizationService {

    private final EmployeeService employeeService;

    @Autowired
    public OrganizationService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Counts all persisted {@link Employee employees} that match given {@link EmployeeProjection projection}.
     *
     * @param projection the projection tested against employees
     * @return the count of matching employees
     */
    public long countEmployees(@NotNull EmployeeProjection projection) {
        requireNonNull(projection);
        return countEmployees(employeeService.getEmployees(projection));
    }

    /**
     * Calculates salaries of all persisted {@link Employee employees} that match given {@link EmployeeProjection projection}.
     *
     * @param projection the projection tested against employees
     * @return the cost of all matching employees
     */
    public long calculateEmployeeCost(@NotNull EmployeeProjection projection) {
        requireNonNull(projection);
        return calculateEmployeeCost(employeeService.getEmployees(projection));
    }

    private long countEmployees(Stream<Employee> employees) {
        return employees.count();
    }

    private long calculateEmployeeCost(Stream<Employee> employees) {
        return employees
                .map(Employee::basicEmployeeInfo)
                .mapToLong(BasicEmployeeInfo::salary)
                .sum();
    }

}
