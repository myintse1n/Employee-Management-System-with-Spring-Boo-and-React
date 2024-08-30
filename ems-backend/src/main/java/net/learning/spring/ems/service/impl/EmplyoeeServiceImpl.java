package net.learning.spring.ems.service.impl;

import lombok.AllArgsConstructor;
import net.learning.spring.ems.dto.EmplyoeeDto;
import net.learning.spring.ems.entity.Employee;
import net.learning.spring.ems.exception.ResourceNotFoundException;
import net.learning.spring.ems.mapper.EmployeeMapper;
import net.learning.spring.ems.repository.EmployeeRepository;
import net.learning.spring.ems.service.EmplyoeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmplyoeeServiceImpl implements EmplyoeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmplyoeeDto createEmplyoee(EmplyoeeDto emplyoeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(emplyoeeDto);
        var svedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmplyoeeDto(svedEmployee);
    }

    @Override
    public EmplyoeeDto getEmployeeById(Long EmployeeId) {

        var employee = employeeRepository.findById(EmployeeId).orElseThrow(() -> {
            return new ResourceNotFoundException("Employee doen't exist at the given id : " + EmployeeId);
        });
        return EmployeeMapper.mapToEmplyoeeDto(employee);
    }

    @Override
    public List<EmplyoeeDto> getAllEmployees() {

        var employees = employeeRepository.findAll();
        return employees.stream()
                .map((employee) -> EmployeeMapper.mapToEmplyoeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmplyoeeDto updateEmployee(Long id, EmplyoeeDto emplyoeeDto) {

        var employee = employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Emploee doesn't exit in the given id: "+id));
        employee.setFirstName(emplyoeeDto.getFirstName());
        employee.setLastName(emplyoeeDto.getLastName());
        employee.setEmail(emplyoeeDto.getEmail());
        employeeRepository.save(employee);
        return  EmployeeMapper.mapToEmplyoeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long id) {

        var employee = employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee doen't exist at your given id : "+id)
        );

        employeeRepository.delete(employee);
    }
}
