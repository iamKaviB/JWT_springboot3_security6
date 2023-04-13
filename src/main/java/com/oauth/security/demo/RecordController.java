package com.oauth.security.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/record")
@AllArgsConstructor
public class RecordController {

  @PostMapping
  public ResponseEntity<String> save() {
    return ResponseEntity.ok("Hello from secured endpoint");
  }

}
