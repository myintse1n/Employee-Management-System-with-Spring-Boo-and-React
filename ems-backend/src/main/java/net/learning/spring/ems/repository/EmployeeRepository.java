package net.learning.spring.ems.repository;

import net.learning.spring.ems.entity.Employee;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface EmployeeRepository extends JpaRepositoryImplementation<Employee, Long> {
}
