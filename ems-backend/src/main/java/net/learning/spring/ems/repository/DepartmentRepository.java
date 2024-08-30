package net.learning.spring.ems.repository;

import net.learning.spring.ems.entity.Department;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface DepartmentRepository extends JpaRepositoryImplementation<Department, Long> {
}
