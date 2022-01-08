package com.vinisolon.springbootuserdepartment.dto;

import lombok.Data;

@Data
public class UserDepartmentViewDTO {
    private String email;
    private String password;
    private String departmentName;
}
