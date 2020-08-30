package com.jakubeeee.playground.msjava.organization.internal;

import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends EmployeeRepository<WorkerEntity, Long> {}
