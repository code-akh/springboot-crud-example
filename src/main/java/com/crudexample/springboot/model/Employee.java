package com.crudexample.springboot.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @ApiModelProperty(required = true, value = "EmpId")
    private long id;

    @Column(name="firstName", nullable = false)
    @ApiModelProperty(required = true, value  = "Employee First Name")
    private String firstName;

    @Column(name="lastName")
    @ApiModelProperty(required = true, value  = "Employee Last Name")
    private String lastName;

    @Column(name="email")
    @ApiModelProperty(required = true, value  = "Employee Email")
    private String email;
}
