package com.productshut.app.service;

import com.productshut.app.model.Admin;

import java.util.List;

public interface AdminService {
    public Admin saveAdmin(Admin admin) ;
    public List<Admin> getAdmins() ;
    public String deleteAdmin(int id) ;
}
