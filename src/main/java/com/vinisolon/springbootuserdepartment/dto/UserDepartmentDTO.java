package com.vinisolon.springbootuserdepartment.dto;

import lombok.Data;

@Data
public class UserDepartmentDTO {
//    private Long id;
    private String email;
    private String password;
    private Long departmentId;
//    private String departmentName;
}
