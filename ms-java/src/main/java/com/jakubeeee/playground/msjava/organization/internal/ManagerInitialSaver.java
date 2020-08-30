package com.jakubeeee.playground.msjava.organization.internal;

import org.springframework.stereotype.Component;

import java.util.stream.Stream;

import static com.jakubeeee.playground.msjava.organization.Position.REGULAR;
import static com.jakubeeee.playground.msjava.organization.Position.SENIOR;

@Component
public class ManagerInitialSaver extends EmployeeInitialSaver<ManagerEntity, ManagerRepository> {

    private final DepartmentRepository departmentRepository;

    public ManagerInitialSaver(ManagerRepository repository, DepartmentRepository departmentRepository) {
        super(repository);
        this.departmentRepository = departmentRepository;
    }

    @Override
    protected Stream<ManagerEntity> initialEntities() {
        var itDepartment = departmentRepository.getOneByName("Information technologies");
        var marketingDepartment = departmentRepository.getOneByName("Marketing");
        var hrDepartment = departmentRepository.getOneByName("Human Resources");
        return Stream.of(
                new ManagerEntity("ManagerIT", SENIOR, 5000, itDepartment),
                new ManagerEntity("ManagerM", REGULAR, 3500, marketingDepartment),
                new ManagerEntity("ManagerHR", REGULAR, 4000, hrDepartment)
        );
    }

}
