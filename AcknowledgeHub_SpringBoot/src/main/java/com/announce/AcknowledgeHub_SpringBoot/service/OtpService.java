/*
package com.announce.AcknowledgeHub_SpringBoot.service;


import com.announce.AcknowledgeHub_SpringBoot.entity.User;
import com.announce.AcknowledgeHub_SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OtpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    private static final int OTP_VALID_DURATION = 3; // in minutes

    public String generateOtp() {
        return String.valueOf((int)(Math.random() * 900000) + 100000);
    }

    public void sendOtpEmail(String email) {
        String otp = generateOtp();
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(OTP_VALID_DURATION);

        User user = userRepository.findByEmail(email)
                .orElse(new User());
        user.setEmail(email);
        user.setOtp(otp);
        user.setOtpExpirationTime(expirationTime);
        userRepository.save(user);

        String subject = "Your OTP Code";
        String text = "Your OTP code is " + otp + ". It will expire in " + OTP_VALID_DURATION + " minutes.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

    public boolean validateOtp(String email, String otp) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            if (user.getOtp().equals(otp) && user.getOtpExpirationTime().isAfter(LocalDateTime.now())) {
                user.set_delete(false); // Activate the account
                user.setOtp(null);
                user.setOtpExpirationTime(null);
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    public void resendOtpIfNotVerified(String email) {
        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            if (user.is_delete()) {
                sendOtpEmail(email); // Resend OTP
            }
        } else {
            sendOtpEmail(email); // Send OTP if user doesn't exist
        }
    }
}
*/
