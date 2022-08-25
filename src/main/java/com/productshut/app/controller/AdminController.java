package com.productshut.app.controller;

import com.productshut.app.model.Admin;
import com.productshut.app.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminServiceImpl service ;

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
    public List<Admin> fetchAdmins(){
        return service.getAdmins() ;
    }
    @DeleteMapping("/admin/{id}")
    public String deleteAdmin(@PathVariable int id){
        return service.deleteAdmin(id) ;
    }
}
