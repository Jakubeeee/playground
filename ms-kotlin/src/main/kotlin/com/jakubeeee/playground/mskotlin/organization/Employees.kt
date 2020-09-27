package com.jakubeeee.playground.mskotlin.organization

import com.jakubeeee.playground.common.jpa.DataContainer

sealed class Employee : DataContainer {
    abstract val basicEmployeeInfo: BasicEmployeeInfo
}

data class Manager(override val basicEmployeeInfo: BasicEmployeeInfo) : Employee()

data class Worker(override val basicEmployeeInfo: BasicEmployeeInfo, val manager: Manager) : Employee()

data class BasicEmployeeInfo(val lastName: String, val position: Position, val salary: Long, val department: Department)

enum class Position { JUNIOR, REGULAR, SENIOR }