package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.InitialSaver;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

import static com.jakubeeee.playground.msjava.organization.Position.*;

@Component
public class EmployeeInitialSaver extends InitialSaver<EmployeeEntity, EmployeeRepository> {

    private final DepartmentRepository departmentRepository;

    protected EmployeeInitialSaver(EmployeeRepository repository, DepartmentRepository departmentRepository) {
        super(repository);
        this.departmentRepository = departmentRepository;
    }

    @Override
    protected Stream<EmployeeEntity> initialEntities() {
        var itDepartment = departmentRepository.getOneByName("Information_Technologies");
        var marketingDepartment = departmentRepository.getOneByName("Marketing");
        var hrDepartment = departmentRepository.getOneByName("Human_Resources");
        var managerIT = new ManagerEntity("ManagerIT", SENIOR, 5000, itDepartment);
        var managerMarketing = new ManagerEntity("ManagerM", REGULAR, 3500, marketingDepartment);
        var managerHR = new ManagerEntity("ManagerHR", REGULAR, 4000, hrDepartment);
        return Stream.of(
                managerIT,
                managerMarketing,
                managerHR,
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
