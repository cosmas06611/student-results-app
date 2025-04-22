package com.studentResultManagementSystem.resultMgtSys.Controller;

import com.studentResultManagementSystem.resultMgtSys.model.Users;
import com.studentResultManagementSystem.resultMgtSys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

//    this is for user to register

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users){
        return userService.registerUser(users);
    }
}
