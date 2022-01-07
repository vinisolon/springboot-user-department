package com.vinisolon.springbootuserdepartment.services;

import com.vinisolon.springbootuserdepartment.domain.Department;
import com.vinisolon.springbootuserdepartment.domain.User;
import com.vinisolon.springbootuserdepartment.dto.UserDepartmentDTO;
import com.vinisolon.springbootuserdepartment.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(Long id) {
        try {
            return repo.findById(id).get();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    public User insert(User obj) {
        return repo.save(obj);
    }

    private UserDepartmentDTO entityToDto(User user) {
        UserDepartmentDTO dto = new UserDepartmentDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setDepartmentId(user.getDepartment().getId());
        dto.setDepartmentName(user.getDepartment().getName());
        return dto;
    }

    private User entityToDto(UserDepartmentDTO dto) {
        User user = new User();
        Department department = new Department();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        department.setId(dto.getDepartmentId());
        department.setName(dto.getDepartmentName());
        user.setDepartment(department);
        return user;
    }
}
