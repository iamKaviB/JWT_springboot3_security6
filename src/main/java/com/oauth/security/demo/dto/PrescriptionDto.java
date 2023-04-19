package com.oauth.security.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrescriptionDto {

    private String auth;
    private String nic;
    private String disease;
    private String type ="PRES";
    private List<PresDetailDto> list;
    private String firstname;
    private String lastname;
    private String gender;
    private int age;
    private String name;

}
