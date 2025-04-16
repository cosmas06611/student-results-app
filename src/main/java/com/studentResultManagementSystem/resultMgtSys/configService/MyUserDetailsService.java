package com.studentResultManagementSystem.resultMgtSys.configService;

import com.studentResultManagementSystem.resultMgtSys.configRepository.UserRepo;
import com.studentResultManagementSystem.resultMgtSys.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String staffNo) throws UsernameNotFoundException {

        Users user = userRepo.findByStaffNo(staffNo);
        if(user == null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }else
            return null;
    }
}
