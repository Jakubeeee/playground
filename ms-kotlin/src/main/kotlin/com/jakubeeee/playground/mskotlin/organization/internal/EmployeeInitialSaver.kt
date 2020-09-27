package com.jakubeeee.playground.mskotlin.organization.internal

import com.jakubeeee.playground.common.jpa.InitialSaver
import com.jakubeeee.playground.mskotlin.organization.Position.*
import org.springframework.stereotype.Component
import java.util.stream.Stream

@Component
open class EmployeeInitialSaver protected constructor(repository: EmployeeRepository, private val departmentRepository: DepartmentRepository)
    : InitialSaver<EmployeeEntity, EmployeeRepository>(repository) {

    override fun initialEntities(): Stream<EmployeeEntity> {
        val itDepartment = departmentRepository.getOneByName("Information_Technologies")
        val marketingDepartment = departmentRepository.getOneByName("Marketing")
        val hrDepartment = departmentRepository.getOneByName("Human_Resources")
        val rndDepartment = departmentRepository.getOneByName("Research_And_Development")
        val accountingDepartment = departmentRepository.getOneByName("Accounting")
        val managerIT = ManagerEntity("ManagerIT", SENIOR, 5000, itDepartment)
        val managerMarketing = ManagerEntity("ManagerM", REGULAR, 3500, marketingDepartment)
        val managerHR = ManagerEntity("ManagerHR", REGULAR, 4000, hrDepartment)
        val managerRnD = ManagerEntity("ManagerRnd", SENIOR, 6000, rndDepartment)
        val managerAccounting = ManagerEntity("ManagerA", SENIOR, 5000, accountingDepartment)
        return Stream.of(
                managerIT,
                managerMarketing,
                managerHR,
                managerRnD,
                managerAccounting,
                WorkerEntity("WorkerIT1", JUNIOR, 2000, itDepartment, managerIT),
                WorkerEntity("WorkerIT2", REGULAR, 2500, itDepartment, managerIT),
                WorkerEntity("WorkerIT3", REGULAR, 2500, itDepartment, managerIT),
                WorkerEntity("WorkerIT4", JUNIOR, 1500, itDepartment, managerIT),
                WorkerEntity("WorkerIT5", SENIOR, 3000, itDepartment, managerIT),
                WorkerEntity("WorkerM1", JUNIOR, 2000, marketingDepartment, managerMarketing),
                WorkerEntity("WorkerM2", REGULAR, 2500, marketingDepartment, managerMarketing),
                WorkerEntity("WorkerHR1", SENIOR, 3000, hrDepartment, managerHR),
                WorkerEntity("WorkerRnD1", JUNIOR, 2500, rndDepartment, managerRnD),
                WorkerEntity("WorkerRnD2", REGULAR, 3000, rndDepartment, managerRnD),
                WorkerEntity("WorkerRnD3", REGULAR, 2500, rndDepartment, managerRnD),
                WorkerEntity("WorkerA", JUNIOR, 2000, accountingDepartment, managerAccounting)
        )
    }

}