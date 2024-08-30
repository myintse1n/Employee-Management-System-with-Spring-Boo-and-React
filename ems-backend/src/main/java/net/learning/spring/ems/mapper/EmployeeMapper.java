package net.learning.spring.ems.mapper;

import net.learning.spring.ems.dto.EmplyoeeDto;
import net.learning.spring.ems.entity.Employee;

public class EmployeeMapper {

    public static EmplyoeeDto mapToEmplyoeeDto(Employee employee) {
        return new EmplyoeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmplyoeeDto emplyoeeDto) {
        return new Employee(
                emplyoeeDto.getId(),
                emplyoeeDto.getFirstName(),
                emplyoeeDto.getLastName(),
                emplyoeeDto.getEmail()
        );
    }
}
