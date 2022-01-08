package com.vinisolon.springbootuserdepartment.controllers;

import com.vinisolon.springbootuserdepartment.domain.User;
import com.vinisolon.springbootuserdepartment.dto.UserDepartmentInsertDTO;
import com.vinisolon.springbootuserdepartment.dto.UserDepartmentViewDTO;
import com.vinisolon.springbootuserdepartment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<UserDepartmentViewDTO>> getAllUsersDepartment() {
        List<UserDepartmentViewDTO> list = service.getAllUsersDepartment();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDepartmentViewDTO> getUserDepartment(@PathVariable Long id) {
        UserDepartmentViewDTO obj = service.getUserDepartment(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<User> insert(@RequestBody UserDepartmentInsertDTO dto) {
        User saveObj = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveObj.getId()).toUri();
        return ResponseEntity.created(uri).body(saveObj);
    }
}
