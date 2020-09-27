package com.jakubeeee.playground.mskotlin.organization

/**
 * Represents a projection on [Employee] objects that is used for finding any objects that are matching given arguments.
 * If any argument is `null` then it is not taken into account.
 *
 * For example, a projection given as:
 *
 * `EmployeeProjection(null, null, null, null)` - matches with every employee.
 *
 * `EmployeeProjection("WORKER", null, null, "Smith")` - matches with every worker working under the Smith manager.
 *
 * `EmployeeProjection("MANAGER", SENIOR, "Marketing", null)` - matches with every senior manager working in the marketing department.
 */
data class EmployeeProjection(val type: String?,
                              val position: Position?,
                              val departmentName: String?,
                              val managerName: String?)