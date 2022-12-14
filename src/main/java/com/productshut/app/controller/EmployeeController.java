package com.productshut.app.controller;

import com.productshut.app.dto.EmployeeDTO;
import com.productshut.app.model.Employee;
import com.productshut.app.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service ;

    @Autowired
    ModelMapper modelMapper ;

    @PostMapping("/addEmp")
   public Employee addEmployee(@RequestBody Employee employee){
       return service.addEmployee(employee) ;
   }
   @GetMapping("/emp")
   public List<Employee> getEmployee(){
      return service.getEmployee() ; // need to fix this model mapper and Employee DTOs
   }

   @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity getAllEmployees(){
        List<Employee> employeeList = service.getEmployee() ;
        List<EmployeeDTO> employeeDTOList = new ArrayList<>() ;
        for (Employee employee : employeeList){
            System.out.println(employee);
            employeeDTOList.add(modelMapper.map(employee,EmployeeDTO.class)) ;
        }
        return new ResponseEntity<>(employeeDTOList,HttpStatus.OK) ;
   }
}
