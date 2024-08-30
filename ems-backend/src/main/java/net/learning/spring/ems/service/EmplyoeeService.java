package net.learning.spring.ems.service;

import net.learning.spring.ems.dto.EmplyoeeDto;

import java.util.List;

public interface EmplyoeeService {
   EmplyoeeDto createEmplyoee(EmplyoeeDto emplyoeeDto);

   EmplyoeeDto getEmployeeById(Long id);

   List<EmplyoeeDto> getAllEmployees();

   EmplyoeeDto updateEmployee(Long id, EmplyoeeDto emplyoeeDto);

   void deleteEmployee(Long id);
}
