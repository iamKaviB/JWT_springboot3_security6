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
    private String disease;
    private String type ="PRES";
    private List<PresDetailDto> list;
}
