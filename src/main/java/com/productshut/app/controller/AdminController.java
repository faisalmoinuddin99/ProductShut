package com.productshut.app.controller;

import com.productshut.app.dto.AdminDTO;
import com.productshut.app.model.Admin;
import com.productshut.app.service.AdminServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AdminController {

    @Autowired
    AdminServiceImpl service ;

    @Autowired
    ModelMapper modelMapper ;

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){

        Admin savedAdmin = service.saveAdmin(admin) ;
        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAdmin.getAdminId()).toUri() ;
        return ResponseEntity.created(location).build() ;
    }

    @GetMapping("/admins")
    public ResponseEntity<List<AdminDTO>> fetchAdmins(){
        List<Admin> adminList = service.getAdmins() ;
        if (adminList.size() <= 0){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
        }else{
            List<AdminDTO> adminDTOList = adminList
                    .stream()
                    .map(admin -> modelMapper.map(admin,AdminDTO.class))
                    .collect(Collectors.toList());

            return ResponseEntity.of(Optional.of(adminDTOList)) ;
        }
    }
    @DeleteMapping("/admin/{id}")
    public String deleteAdmin(@PathVariable int id){
        return service.deleteAdmin(id) ;
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminDTO> getAdminDetails(@PathVariable int id){
        Admin adminResponse = service.getAdminById(id) ;
        AdminDTO responseAdminDTO = modelMapper.map(adminResponse,AdminDTO.class) ;

        return new ResponseEntity<AdminDTO>(responseAdminDTO, HttpStatus.OK) ;
    }

}
