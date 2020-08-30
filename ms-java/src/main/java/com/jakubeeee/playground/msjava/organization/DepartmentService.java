package com.jakubeeee.playground.msjava.organization;

import com.jakubeeee.playground.msjava.organization.internal.DepartmentMapper;
import com.jakubeeee.playground.msjava.organization.internal.DepartmentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class DepartmentService {

    private static final DepartmentMapper departmentMapper = DepartmentMapper.getInstance();

    private final DepartmentRepository repository;

    @Autowired
    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department getDepartment(@NotNull String name) {
        requireNonNull(name);
        var departmentEntity = repository.getOneByName(name);
        return departmentMapper.toDataContainer(departmentEntity);
    }

}
