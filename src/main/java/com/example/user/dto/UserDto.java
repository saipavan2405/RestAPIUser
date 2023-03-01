package com.example.user.dto;

import lombok.Data;

import java.util.List;


@Data
public class UserDto {

    private long id;

    private String fname;
    private String lname;
    private String score;
    private List<FeatureDto> features;



}
