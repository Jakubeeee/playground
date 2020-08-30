package com.jakubeeee.playground.msjava.organization.internal;

import com.jakubeeee.playground.msjava.organization.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity getOneByLastName(String lastName);

    @Query("""
             SELECT e FROM EmployeeEntity e 
                 WHERE (e IN (SELECT m from ManagerEntity m) OR e IN (SELECT w from WorkerEntity w WHERE (:managerName IS NULL OR w.manager.lastName = :managerName)))
                 AND (:type IS NULL OR e.type = :type) 
                 AND (:position IS NULL OR e.position = :position)
                 AND (:departmentName IS NULL OR e.department.name = :departmentName)
            """
    )
    Set<EmployeeEntity> findAll(@Param("type") String type, @Param("position") Position position, @Param("departmentName") String departmentName, @Param("managerName") String managerName);

}
