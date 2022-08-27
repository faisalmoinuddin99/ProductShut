package com.productshut.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee_TBL")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId ;

    @Column(name = "employeeFirstName", nullable=false)
    private String employeeFirstName ;

    @Column(name = "employeeLastName", nullable=false)
    private String employeeLastName ;

    @Column(name = "username", nullable=false)
    private String username ;

    @Column(name = "password", nullable=false)
    private String password ;

    @Column(name = "dateOfBirth", nullable=false)
    private String dateOfBirth ;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_contact_number",joinColumns = @JoinColumn(name = "employeeId"))
    @Column(name = "mobile_number", nullable = false)
    private Set<String> phone ;



}
