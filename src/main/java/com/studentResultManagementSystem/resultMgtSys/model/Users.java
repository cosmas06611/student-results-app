package com.studentResultManagementSystem.resultMgtSys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users {
    @Id
    private String staffNo;
    private String staffName;
    private String staffBranch;
    private String staffDept;
    private String staffZone;


}
