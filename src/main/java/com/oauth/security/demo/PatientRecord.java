package com.oauth.security.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "_record")
public class PatientRecord {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String username;
    private String type;
    private String disease;
    private String prescription;
    private String dateTime;
}
