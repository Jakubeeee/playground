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
                new DepartmentEntity("Information technologies"),
                new DepartmentEntity("Marketing"),
                new DepartmentEntity("Human Resources")
        );
    }

}
