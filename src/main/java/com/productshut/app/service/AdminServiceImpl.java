package com.productshut.app.service;

import com.productshut.app.model.Admin;
import com.productshut.app.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository repository ;

    public Admin saveAdmin(Admin admin){
        return repository.save(admin) ;
    }

    public List<Admin> getAdmins(){
        return repository.findAll() ;
    }
    public Admin getAdminById(int id){
        return repository.findById(id).orElse(null) ;
    }

    @Override
    public List<Admin> getAdminByDeletedStatus(boolean status) {
        return repository.findByIsDeleted(status);
    }

    public String deleteAdmin(int id){
       repository.deleteById(id);
       return "Admin deleted " + id ;
    }
}
