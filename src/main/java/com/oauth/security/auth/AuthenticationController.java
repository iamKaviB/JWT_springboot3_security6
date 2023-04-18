package com.oauth.security.auth;

import com.oauth.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    System.out.println("here 1 ");
    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    System.out.println("here ");
    return ResponseEntity.ok(service.authenticate(request));
  }

  @GetMapping("/find/{nic}")
  public ResponseEntity<RegisterRequest> findByUsername(
          @PathVariable("nic") String nic
  ) {
      User user = service.findByNic(nic);
    System.out.println(user.getNic());

      RegisterRequest request = new RegisterRequest();
      request.setFirstname(user.getFirstname());
      request.setLastname(user.getLastname());
      request.setEmail(user.getEmail());
      request.setAge(user.getAge());
      request.setGender(user.getGender());
      request.setNic(user.getNic());

      return ResponseEntity.ok(request);
  }


  @GetMapping("/patient/{role}")
  public ResponseEntity<List<RegisterRequest>> findByRole(
          @PathVariable("role") String role
  ) {
    List<User> user = service.findAllByRole(role);
    List <RegisterRequest> r = new ArrayList<>();
    for(User u: user)
    {
      RegisterRequest request = new RegisterRequest();
      request.setFirstname(u.getFirstname());
      request.setLastname(u.getLastname());
      request.setEmail(u.getEmail());
      request.setAge(u.getAge());
      request.setGender(u.getGender());
      request.setNic(u.getNic());
      r.add(request);
    }

    return ResponseEntity.ok(r);
  }



}
