package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.common.jpa.InitialSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class DepartmentInitialSaver extends InitialSaver<DepartmentEntity, DepartmentRepository> {

    @Autowired
    public DepartmentInitialSaver(DepartmentRepository repository) {
        super(repository);
    }

    @Override
    protected Stream<DepartmentEntity> initialEntities() {
        return Stream.of(
                new DepartmentEntity("Information_Technologies"),
                new DepartmentEntity("Marketing"),
                new DepartmentEntity("Human_Resources"),
                new DepartmentEntity("Research_And_Development"),
                new DepartmentEntity("Accounting")
        );
    }

}
