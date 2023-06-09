package com.oauth.security.demo;

import com.oauth.security.demo.dto.EcgDto;
import com.oauth.security.demo.dto.PrescriptionDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/record")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RecordController {

  private final PatientRecordService service;
  @PostMapping("/save/pres")
  public ResponseEntity<PatientRecord> savePres(@RequestBody PrescriptionDto prescriptionDto , @RequestHeader("Authorization") String auth) {
    prescriptionDto.setAuth(auth.split(" ")[1]);
    System.out.println(auth);
    return ResponseEntity.ok(service.savePrescription(prescriptionDto));
  }

  @PostMapping("/save/ecg")
  public ResponseEntity<PatientRecord> saveEcg(@RequestBody EcgDto ecgDto , @RequestHeader("Authorization") String auth) {
    ecgDto.setAuth(auth.split(" ")[1]);
    System.out.println(auth);
    return ResponseEntity.ok(service.saveEcg(ecgDto));
  }

  @GetMapping("/pres")
  private ResponseEntity<List<PrescriptionDto>> getPrescriptions(){
    return ResponseEntity.ok(service.getPrescriptions());
  }

  @GetMapping("/pres/{nic}")
  private ResponseEntity<List<PrescriptionDto>> getPrescriptionsByNic(@PathVariable("nic") String nic){
    return ResponseEntity.ok(service.getPrescriptionsByNic(nic));
  }

  @GetMapping("/ecg")
  private ResponseEntity<List<EcgDto>> getEcg(){
    return ResponseEntity.ok(service.getEcg());
  }

  @GetMapping("/ecg/{nic}")
  private ResponseEntity<List<EcgDto>> getEcgByNic(@PathVariable("nic") String nic){
    return ResponseEntity.ok(service.getEcgByUsername(nic));
  }

}
