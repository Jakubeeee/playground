package com.jakubeeee.playground.msjava.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {

    private final OrganizationService service;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    // curl http://localhost:8080/count?type=WORKER&position=REGULAR&departmentName=Information_Technologies&managerName=ManagerIT
    @GetMapping("count")
    public long countEmployees(@RequestParam(value = "type", required = false) String type,
                               @RequestParam(value = "position", required = false) Position position,
                               @RequestParam(value = "departmentName", required = false) String departmentName,
                               @RequestParam(value = "managerName", required = false) String managerName) {
        return service.countEmployees(new EmployeeProjection(type, position, departmentName, managerName));
    }

    // curl http://localhost:8080/cost?type=WORKER&position=REGULAR&departmentName=Information_Technologies&managerName=ManagerIT
    @GetMapping("cost")
    public long calculateEmployeeCost(@RequestParam(value = "type", required = false) String type,
                                      @RequestParam(value = "position", required = false) Position position,
                                      @RequestParam(value = "departmentName", required = false) String departmentName,
                                      @RequestParam(value = "managerName", required = false) String managerName) {
        return service.calculateEmployeeCost(new EmployeeProjection(type, position, departmentName, managerName));
    }

}
