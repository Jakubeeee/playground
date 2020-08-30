package com.jakubeeee.playground.msjava.organization;

public record BasicEmployeeInfo(
        String lastName,
        Position position,
        long salary,
        Department department) {}