package com.jakubeeee.playground.mskotlin.organization.internal

import com.jakubeeee.playground.common.jpa.InitialSaver
import org.springframework.stereotype.Component
import java.util.stream.Stream

@Component
open class DepartmentInitialSaver(repository: DepartmentRepository) : InitialSaver<DepartmentEntity, DepartmentRepository>(repository) {

    override fun initialEntities(): Stream<DepartmentEntity> {
        return Stream.of(
                DepartmentEntity("Information_Technologies"),
                DepartmentEntity("Marketing"),
                DepartmentEntity("Human_Resources"),
                DepartmentEntity("Research_And_Development"),
                DepartmentEntity("Accounting")
        )
    }

}