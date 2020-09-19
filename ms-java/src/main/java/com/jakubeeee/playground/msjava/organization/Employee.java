package com.jakubeeee.playground.msjava.organization;

import com.jakubeeee.playground.common.jpa.DataContainer;

public sealed interface Employee extends DataContainer permits Worker, Manager {
    BasicEmployeeInfo basicEmployeeInfo();
}
