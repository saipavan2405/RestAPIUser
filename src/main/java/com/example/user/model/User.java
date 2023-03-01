package com.example.user.model;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name= "customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "first_name")
    public String fname;

    @Column(name = "last_name")
    public String lname;

    public User(int i, String dan, String miller) {
    }

    //private Score score;

}
