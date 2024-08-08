package com.announce.AcknowledgeHub_SpringBoot.controller;


import com.announce.AcknowledgeHub_SpringBoot.model.AuthenticationResponse;
import com.announce.AcknowledgeHub_SpringBoot.model.UserDTO;
import com.announce.AcknowledgeHub_SpringBoot.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/user")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDTO request) {
        try {
            return ResponseEntity.ok(authenticationService.register(request));
        } catch (RuntimeException e) {
            AuthenticationResponse response = new AuthenticationResponse();
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

}

