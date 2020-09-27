package com.jakubeeee.playground.mskotlin.organization

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
open class OrganizationController(private val service: OrganizationService) {

    // curl http://localhost:8080/count?type=WORKER&position=REGULAR&departmentName=Information_Technologies&managerName=ManagerIT
    @GetMapping("count")
    fun countEmployees(@RequestParam(value = "type", required = false) type: String?,
                       @RequestParam(value = "position", required = false) position: Position?,
                       @RequestParam(value = "departmentName", required = false) departmentName: String?,
                       @RequestParam(value = "managerName", required = false) managerName: String?): Long {
        return service.countEmployees(EmployeeProjection(type, position, departmentName, managerName))
    }

    // curl http://localhost:8080/cost?type=WORKER&position=REGULAR&departmentName=Information_Technologies&managerName=ManagerIT
    @GetMapping("cost")
    fun calculateEmployeeCost(@RequestParam(value = "type", required = false) type: String?,
                              @RequestParam(value = "position", required = false) position: Position?,
                              @RequestParam(value = "departmentName", required = false) departmentName: String?,
                              @RequestParam(value = "managerName", required = false) managerName: String?): Long {
        return service.calculateEmployeeCost(EmployeeProjection(type, position, departmentName, managerName))
    }

}