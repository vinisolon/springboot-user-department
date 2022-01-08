package com.vinisolon.springbootuserdepartment.dto;

import lombok.Data;

@Data
public class UserDepartmentInsertDTO {
    private String email;
    private String password;
    private Long departmentId;
}
