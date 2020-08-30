package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.InitialSaver;

abstract class EmployeeInitialSaver<E extends EmployeeEntity, R extends EmployeeRepository<E, Long>>
        extends InitialSaver<E, R> {

    protected EmployeeInitialSaver(R repository) {
        super(repository);
    }

}
