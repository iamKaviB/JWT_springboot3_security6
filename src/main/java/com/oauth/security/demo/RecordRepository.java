package com.oauth.security.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<PatientRecord,Integer> {

    List<PatientRecord> findAllByType(String type);
    List<PatientRecord> findAllByTypeAndUsername(String type, String nic);
}
