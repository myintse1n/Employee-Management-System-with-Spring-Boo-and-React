package net.learning.spring.ems.service.impl;

import net.learning.spring.ems.dto.DepartmentDto;
import net.learning.spring.ems.exception.ResourceNotFoundException;
import net.learning.spring.ems.mapper.DepartmentMapper;
import net.learning.spring.ems.repository.DepartmentRepository;
import net.learning.spring.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        var createDepartment = departmentRepository.save(DepartmentMapper.mapToDepartment(departmentDto));

        return DepartmentMapper.mapToDepartmentDto(createDepartment);
    }

    @Override
    public List<DepartmentDto> getDepartments() {

        var departments = departmentRepository.findAll();

        return departments.stream()
                .map((department)-> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        var department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("There is no department at the given id"+departmentId));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {

        var department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department doesn't exist at your given id "+ departmentId));

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());

        departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        var department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department doesn't exist at given id."+ departmentId));

        departmentRepository.delete(department);
    }
}
