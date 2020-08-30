package com.jakubeeee.playground.msjava.organization;

import org.jetbrains.annotations.Nullable;

/**
 * Represents a projection on {@link Employee} objects that is used for finding any objects that are matching given arguments.
 * If any argument is {@code null} then it is not taken into an account.
 * <p>For example, a projection given as:</p>
 * <p>{@code new EmployeeProjection(null, null, null, null);} - matches with every employee.</p>
 * <p>{@code new EmployeeProjection("WORKER", null, null, "Smith");} - matches with every worker working under the Smith manager.</p>
 * <p>{@code new EmployeeProjection("MANAGER", SENIOR, "Marketing", null);} - matches with every senior manager working in the marketing department.</p>
 */
public record EmployeeProjection(@Nullable String type,
                                 @Nullable Position position,
                                 @Nullable String departmentName,
                                 @Nullable String managerName) {}
