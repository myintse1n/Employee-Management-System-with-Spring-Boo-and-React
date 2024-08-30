package net.learning.spring.ems.controller;

import net.learning.spring.ems.dto.DepartmentDto;
import net.learning.spring.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //Build Create Department Rest Api
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        var saveDepartment = departmentService.createDepartment(departmentDto);

        return  new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public List<DepartmentDto> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("{id}")
    public DepartmentDto getDepartmentById(@PathVariable("id") Long departmentId){

        return departmentService.getDepartmentById(departmentId);
    }

    @PutMapping("{id}")
    public DepartmentDto updateDepartment(
            @PathVariable("id") Long DepartmentId,
            @RequestBody DepartmentDto departmentDto
    ){
        return  departmentService.updateDepartment(DepartmentId,departmentDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return  new ResponseEntity<>("Department deleted successfully.",HttpStatus.OK) ;
    }
}
