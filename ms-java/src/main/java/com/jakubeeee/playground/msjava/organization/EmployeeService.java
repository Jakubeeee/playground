package com.jakubeeee.playground.msjava.organization;

import com.jakubeeee.playground.msjava.organization.internal.EmployeeMapper;
import com.jakubeeee.playground.msjava.organization.internal.EmployeeRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

@Service
public class EmployeeService {

    private static final EmployeeMapper employeeMapper = EmployeeMapper.getInstance();

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee getEmployee(@NotNull String lastName) {
        requireNonNull(lastName);
        var employeeEntity = repository.getOneByLastName(lastName);
        return employeeMapper.toDataContainer(employeeEntity);
    }

    public Stream<Employee> getEmployees(@Nullable String type, @Nullable Position position, @Nullable String departmentName, @Nullable String managerName) {
        return repository.findAll(type, position, departmentName, managerName).stream()
                .map(employeeMapper::toDataContainer);
    }

}
