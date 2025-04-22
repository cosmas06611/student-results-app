package com.studentResultManagementSystem.resultMgtSys.service;

import com.studentResultManagementSystem.resultMgtSys.configRepository.UserRepo;
import com.studentResultManagementSystem.resultMgtSys.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users registerUser(Users users){
        users.setStaffPassword(encoder.encode(users.getStaffPassword()));
        return userRepo.save(users);
    }
}
