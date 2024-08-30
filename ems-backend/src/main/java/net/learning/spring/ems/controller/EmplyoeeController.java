package net.learning.spring.ems.controller;

import net.learning.spring.ems.dto.EmplyoeeDto;
import net.learning.spring.ems.service.EmplyoeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/employees")
public class EmplyoeeController {

    @Autowired
    private EmplyoeeService emplyoeeService;

    // Build create Employee Rest Api
    @PostMapping
    public ResponseEntity<EmplyoeeDto> createEmployee(@RequestBody EmplyoeeDto emplyoeeDto){
        EmplyoeeDto savedEmployee = emplyoeeService.createEmplyoee(emplyoeeDto);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build get Employee by Id Rest Api
    @GetMapping("{id}")
    public ResponseEntity<EmplyoeeDto> getEmployeeById(@PathVariable Long id){
        var employeeDto =   emplyoeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    //Build get All Employees Rest Api
    @GetMapping("all")
    public ResponseEntity<List<EmplyoeeDto>> getAllEmployees(){

        var allEmployees = emplyoeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    //Build Update Employee Rest Api
    @PutMapping("{id}")
    public ResponseEntity<EmplyoeeDto> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmplyoeeDto emplyoeeDto){

        var employeeDto =  emplyoeeService.updateEmployee(id,emplyoeeDto);

        return ResponseEntity.ok(employeeDto);
    }

    //Build Delete Employee Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String>  deleteEmployee(@PathVariable Long id){
        emplyoeeService.deleteEmployee(id);
        return  new ResponseEntity<>("Employee deleted successfully",HttpStatus.OK);
    }
}
