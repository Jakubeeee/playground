package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.EntityMapper;
import com.jakubeeee.playground.msjava.organization.BasicEmployeeInfo;
import com.jakubeeee.playground.msjava.organization.Employee;
import com.jakubeeee.playground.msjava.organization.Manager;
import com.jakubeeee.playground.msjava.organization.Worker;
import org.jetbrains.annotations.NotNull;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class EmployeeMapper implements EntityMapper<EmployeeEntity, Employee> {

    private static final EmployeeMapper instance = new EmployeeMapper();

    private static final DepartmentMapper departmentMapper = DepartmentMapper.getInstance();

    public static EmployeeMapper getInstance() {
        return instance;
    }

    private EmployeeMapper() {
    }

    @Override
    public EmployeeEntity toEntity(@NotNull Employee employee) {
        requireNonNull(employee);
        if (employee instanceof Manager manager)
            return toEntity(manager);
        else if (employee instanceof Worker worker)
            return toEntity(worker);
        else
            throw new IllegalStateException(format("Employee type \"%s\" is not supported", employee));
    }

    public ManagerEntity toEntity(@NotNull Manager manager) {
        requireNonNull(manager);
        var basicEmployeeInfo = manager.basicEmployeeInfo();
        return new ManagerEntity(basicEmployeeInfo.lastName(), basicEmployeeInfo.position(), basicEmployeeInfo.salary(), departmentMapper.toEntity(basicEmployeeInfo.department()));
    }

    public WorkerEntity toEntity(@NotNull Worker worker) {
        requireNonNull(worker);
        var basicEmployeeInfo = worker.basicEmployeeInfo();
        return new WorkerEntity(basicEmployeeInfo.lastName(), basicEmployeeInfo.position(), basicEmployeeInfo.salary(), departmentMapper.toEntity(basicEmployeeInfo.department()), toEntity(worker.manager()));
    }

    @Override
    public Employee toDataContainer(@NotNull EmployeeEntity employeeEntity) {
        requireNonNull(employeeEntity);
        if (employeeEntity instanceof ManagerEntity managerEntity)
            return toDataContainer(managerEntity);
        else if (employeeEntity instanceof WorkerEntity workerEntity)
            return toDataContainer(workerEntity);
        else
            throw new IllegalStateException(format("Employee type \"%s\" is not supported", employeeEntity));
    }

    public Manager toDataContainer(@NotNull ManagerEntity managerEntity) {
        requireNonNull(managerEntity);
        return new Manager(new BasicEmployeeInfo(managerEntity.lastName(), managerEntity.position(), managerEntity.salary(), departmentMapper.toDataContainer(managerEntity.department())));
    }

    public Worker toDataContainer(@NotNull WorkerEntity workerEntity) {
        requireNonNull(workerEntity);
        return new Worker(new BasicEmployeeInfo(workerEntity.lastName(), workerEntity.position(), workerEntity.salary(), departmentMapper.toDataContainer(workerEntity.department())), toDataContainer(workerEntity.manager()));
    }

}
