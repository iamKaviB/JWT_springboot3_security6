package com.oauth.security.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PresDetailDto {

    private String medicine;
    private String usage;
    private String dose;
}
