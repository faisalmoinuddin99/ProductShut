package com.productshut.app.repository;

import com.productshut.app.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    public List<Admin> findByIsDeleted(boolean status) ;
}
