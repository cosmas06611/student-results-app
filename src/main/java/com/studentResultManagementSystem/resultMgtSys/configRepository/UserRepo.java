package com.studentResultManagementSystem.resultMgtSys.configRepository;

import com.studentResultManagementSystem.resultMgtSys.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, String> {

    Users findByStaffNo(String staffNo);
}
