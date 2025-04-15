package com.studentResultManagementSystem.resultMgtSys.service;

import com.studentResultManagementSystem.resultMgtSys.model.StudentUser;
import com.studentResultManagementSystem.resultMgtSys.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public List<StudentUser> getStudentUser(){
        return studentRepo.findAll();
    }

    public StudentUser getStudentById(String staffNo){
        return studentRepo.findById(staffNo).orElse(null);
   }

    public void addStudent(StudentUser newUser) {
         studentRepo.save(newUser);
    }

    public void updateStudentUser(StudentUser updateUser) {
       studentRepo.save(updateUser);
    }

    public void deleteStudentUser(String staffNo) {
        studentRepo.deleteById(staffNo);
        }


//    public StudentUser addStudentUser(StudentUser studUser, MultipartFile imageFile) throws IOException {
//        studUser.setImageName(imageFile.getOriginalFilename());
//        studUser.setImageType(imageFile.getContentType());
//        studUser.setImageData(imageFile.getBytes());
//        return studentRepo.save(studUser);
//    }

//    public StudentUser updateStudent(String staffNo, MultipartFile imageFile, StudentUser studUser) throws IOException {
//        studUser.setImageData(imageFile.getBytes());
//        studUser.setImageType(imageFile.getContentType());
//        studUser.setImageName(imageFile.getOriginalFilename());
//        return studentRepo.save(studUser);
//    }

    public List<StudentUser> searchByStaffNo(String keyword) {
        return studentRepo.searchByStaffNo(keyword);
    }
}