package com.oauth.security.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EcgDto {

    private String auth;
    private String disease;
    private String type = "ECG";
}
