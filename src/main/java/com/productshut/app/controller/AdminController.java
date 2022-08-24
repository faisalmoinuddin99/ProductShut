package com.productshut.app.controller;

import com.productshut.app.model.Admin;
import com.productshut.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService service ;

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        return service.saveAdmin(admin) ;
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
