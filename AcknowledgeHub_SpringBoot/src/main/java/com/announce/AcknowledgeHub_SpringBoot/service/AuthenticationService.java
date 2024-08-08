package com.announce.AcknowledgeHub_SpringBoot.service;


import com.announce.AcknowledgeHub_SpringBoot.entity.User;
import com.announce.AcknowledgeHub_SpringBoot.model.AuthenticationResponse;
import com.announce.AcknowledgeHub_SpringBoot.model.UserDTO;
import com.announce.AcknowledgeHub_SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private MapperService mapperService;


    public AuthenticationResponse register(UserDTO request) {
        User existingUser = userRepository.findByEmail(request.getEmail()).orElse(null);
        User user = mapperService.mapToUserEntity(request);
        //  user.set_delete(true); // Set account as not activated
        user = userRepository.save(user);
      //  otpService.sendOtpEmail(user.getEmail());
        AuthenticationResponse response = new AuthenticationResponse();
        response.setMessage("Registration successful.");
        return response;
    }



}
