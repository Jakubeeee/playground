package com.jakubeeee.playground.msjava.organization;

import com.jakubeeee.playground.msjava.organization.internal.DepartmentEntity;

public record BasicEmployeeInfo(
        String lastName,
        Position position,
        int salary,
        DepartmentEntity department) {}