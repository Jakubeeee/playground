package com.jakubeeee.playground.msjava.organization.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EmployeeRepository<T extends EmployeeEntity, I> extends JpaRepository<T, I> {

    T getOneByLastName(String lastName);

}
