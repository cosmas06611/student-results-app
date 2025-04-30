package com.studentResultManagementSystem.resultMgtSys.service;

import com.studentResultManagementSystem.resultMgtSys.configRepository.UserRepo;
import com.studentResultManagementSystem.resultMgtSys.jwtToken.JwtTokenService;
import com.studentResultManagementSystem.resultMgtSys.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtTokenService jwtToken;

    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users registerUser(Users users) {
        users.setStaffPassword(encoder.encode(users.getStaffPassword()));
        return userRepo.save(users);
    }

    public String verifyUser(Users users) {
        Authentication authenticatedUserSignUpDetails =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(users.getStaffNo(),
                        users.getStaffPassword()));
        if(authenticatedUserSignUpDetails.isAuthenticated())
            return jwtToken.generateToken(users.getStaffNo());

            return "fail";
    }
}
