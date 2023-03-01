package com.example.user.model;

import lombok.Data;

import javax.persistence.*;



@Data
@Entity
@Table(name= "features")
public class Features {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    public User user;

    @Column(name="attribute")
    public String attribute;

    @Column(name="value")
    public String value;

}
