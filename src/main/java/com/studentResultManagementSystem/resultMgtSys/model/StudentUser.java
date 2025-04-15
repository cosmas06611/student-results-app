package com.studentResultManagementSystem.resultMgtSys.model;


import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class StudentUser {
        @Id
    private String staffNo;
    private String studentName;
    private String studentBranch;
    private String studentDept;
    private String position;
    private int fundamentalOfCredit;
    private int basicEmergency;
    private int accounting;
    private int understandingBankingBusiness;
    private int selfMastery;
    private int internalCourses;
    private String remark;
    private int orientationClass;
    private int year;
    private int averageScore;

//    private String imageType;
//    private String imageName;
//    @Lob
//    private byte[] imageData;
}
