package com.jakubeeee.playground.msjava.organization.internal;

import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends EmployeeRepository<ManagerEntity, Long> {}
