package com.jakubeeee.playground.msjava.organization;

import com.jakubeeee.playground.common.jpa.DataContainer;

public interface Employee extends DataContainer {
    BasicEmployeeInfo basicEmployeeInfo();
}
