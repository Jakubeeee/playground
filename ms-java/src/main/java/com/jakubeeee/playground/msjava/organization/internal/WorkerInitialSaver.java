package com.jakubeeee.playground.msjava.organization.internal;

import org.springframework.stereotype.Component;

import java.util.stream.Stream;

import static com.jakubeeee.playground.msjava.organization.Position.*;

@Component
public class WorkerInitialSaver extends EmployeeInitialSaver<WorkerEntity, WorkerRepository> {

    private final DepartmentRepository departmentRepository;

    private final ManagerRepository managerRepository;

    public WorkerInitialSaver(WorkerRepository repository, DepartmentRepository departmentRepository, ManagerRepository managerRepository) {
        super(repository);
        this.departmentRepository = departmentRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    protected Stream<WorkerEntity> initialEntities() {
        var itDepartment = departmentRepository.getOneByName("Information technologies");
        var marketingDepartment = departmentRepository.getOneByName("Marketing");
        var hrDepartment = departmentRepository.getOneByName("Human Resources");
        var managerIT = managerRepository.getOneByLastName("ManagerIT");
        var managerMarketing = managerRepository.getOneByLastName("ManagerM");
        var managerHR = managerRepository.getOneByLastName("ManagerHR");
        return Stream.of(
                new WorkerEntity("WorkerIT1", JUNIOR, 2000, itDepartment, managerIT),
                new WorkerEntity("WorkerIT2", REGULAR, 2500, itDepartment, managerIT),
                new WorkerEntity("WorkerIT3", REGULAR, 2500, itDepartment, managerIT),
                new WorkerEntity("WorkerIT4", JUNIOR, 1500, itDepartment, managerIT),
                new WorkerEntity("WorkerIT5", SENIOR, 3000, itDepartment, managerIT),
                new WorkerEntity("WorkerM1", JUNIOR, 2000, marketingDepartment, managerMarketing),
                new WorkerEntity("WorkerM2", REGULAR, 2500, marketingDepartment, managerMarketing),
                new WorkerEntity("WorkerHR1", SENIOR, 3000, hrDepartment, managerHR)
        );
    }

}
