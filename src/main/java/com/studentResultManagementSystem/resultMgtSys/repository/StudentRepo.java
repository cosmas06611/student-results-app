package com.studentResultManagementSystem.resultMgtSys.repository;

import com.studentResultManagementSystem.resultMgtSys.model.StudentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentUser, String> {
    @Query("SELECT s from StudentUser s WHERE " + " LOWER (s.staffNo) LIKE LOWER (CONCAT ('%',:keyword, '%'))")
    List<StudentUser> searchByStaffNo(String keyword);
}
