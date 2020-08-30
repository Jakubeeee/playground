package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.EntityMapper;
import com.jakubeeee.playground.msjava.organization.Department;
import org.jetbrains.annotations.NotNull;

import static java.util.Objects.requireNonNull;

public class DepartmentMapper implements EntityMapper<DepartmentEntity, Department> {

    private static final DepartmentMapper instance = new DepartmentMapper();

    public static DepartmentMapper getInstance() {
        return instance;
    }

    private DepartmentMapper() {
    }

    @Override
    public DepartmentEntity toEntity(@NotNull Department dataContainer) {
        requireNonNull(dataContainer);
        return new DepartmentEntity(dataContainer.name());
    }

    @Override
    public Department toDataContainer(@NotNull DepartmentEntity entity) {
        requireNonNull(entity);
        return new Department(entity.name());
    }

}
