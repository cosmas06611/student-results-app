package com.studentResultManagementSystem.resultMgtSys.Controller;

import com.studentResultManagementSystem.resultMgtSys.model.StudentUser;
import com.studentResultManagementSystem.resultMgtSys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity <List<StudentUser>> getAllStudent(){
       List <StudentUser> studUser = studentService.getStudentUser();
       if(studUser != null) {
            return new ResponseEntity<>(studUser, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/students/{staffNo}")
    public ResponseEntity<StudentUser> getStudentById(@PathVariable String staffNo){
        StudentUser studUser = studentService.getStudentById(staffNo);
       if(studUser != null){
           return   new ResponseEntity<>(studUser, HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @PostMapping("/student")
    public void addStudentById(@RequestBody StudentUser newUser){
        studentService.addStudent(newUser);
    }

    @PutMapping("/student")
    public void updateStudentUser(@RequestBody StudentUser updateUser){
        studentService.updateStudentUser(updateUser);
    }

    @DeleteMapping("/student/{staffNo}")
    public void deleteStudentUser(@PathVariable String staffNo){
        studentService.deleteStudentUser(staffNo);
    }

//    @PostMapping("/student")
//    public ResponseEntity<?> addStudentUsers(@RequestPart StudentUser studUser,
//                                            @RequestPart MultipartFile imageFile) {
//        try {
//            StudentUser stud = studentService.addStudentUser(studUser, imageFile);
//            return new ResponseEntity<>(stud, HttpStatus.CREATED);
//        } catch (Exception e) {
//
//           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @GetMapping("/student/{staffNo}/image")
//    public ResponseEntity <byte[]> getStaffById(@PathVariable String staffNo){
//        StudentUser stud = studentService.getStudentById(staffNo);
//        byte[] imageFile = stud.getImageData();
//        return ResponseEntity.ok()
//                .contentType(MediaType.valueOf(stud.getImageType()))
//                .body(imageFile);
//
//    }

//    @PutMapping("/student/{staffNo}")
//    public ResponseEntity<String> updateStudent(@PathVariable String staffNo,
//                                                @RequestPart MultipartFile imageFile,
//                                                @RequestPart StudentUser studUser)
//    {
//        StudentUser stud1 = null;
//        try {
//            stud1 = studentService.updateStudent(staffNo, imageFile, studUser);
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        if(stud1 != null){
//            return new ResponseEntity<>("updated", HttpStatus.OK);
//        }else return new ResponseEntity<>("failed to update", HttpStatus.BAD_REQUEST);
//    }

    @GetMapping("/student/search")
    public ResponseEntity<List <StudentUser>> searchByStaffNo(@RequestParam String keyword){
        List <StudentUser> stud1 = studentService.searchByStaffNo(keyword);
        return new ResponseEntity<>(stud1, HttpStatus.OK);
    }
}
