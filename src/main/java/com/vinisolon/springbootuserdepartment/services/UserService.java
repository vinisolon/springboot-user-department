package com.vinisolon.springbootuserdepartment.services;

import com.vinisolon.springbootuserdepartment.domain.User;
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
}
