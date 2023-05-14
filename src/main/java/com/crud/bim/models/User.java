package com.crud.bim.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME")
    private String Name;
    @Column(name = "EMAIL")
    private String Email;
    @Column(name = "YEAR")
    private int year;
}