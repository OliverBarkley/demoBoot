package com.example.demoboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="company")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private int salary;


}
