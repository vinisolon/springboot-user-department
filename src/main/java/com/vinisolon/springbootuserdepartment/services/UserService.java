package com.vinisolon.springbootuserdepartment.services;

import com.vinisolon.springbootuserdepartment.domain.User;
import com.vinisolon.springbootuserdepartment.dto.UserDepartmentDTO;
import com.vinisolon.springbootuserdepartment.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    ModelMapper modelMapper;

    public List<UserDepartmentDTO> getAllUsersDepartment() {
        return repo.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public UserDepartmentDTO getUserDepartment(Long id) {
        try {
            return entityToDto(repo.findById(id).get());
//            return repo.findById(id).get();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    public User insert(UserDepartmentDTO obj) {
        // TODO: Corrigir insert. O user não está gerando ID corretamente.
        return repo.save(dtoToEntity(obj));
    }

    private UserDepartmentDTO entityToDto(User user) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(user, UserDepartmentDTO.class);
    }

    private User dtoToEntity(UserDepartmentDTO dto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(dto, User.class);
    }

    // Conversão de classes implementadas na unha. Boilerplate code.
//    private UserDepartmentDTO entityToDto(User user) {
//        UserDepartmentDTO dto = new UserDepartmentDTO();
//        dto.setId(user.getId());
//        dto.setEmail(user.getEmail());
//        dto.setPassword(user.getPassword());
//        dto.setDepartmentId(user.getDepartment().getId());
//        dto.setDepartmentName(user.getDepartment().getName());
//        return dto;
//    }
//
//    private User entityToDto(UserDepartmentDTO dto) {
//        User user = new User();
//        Department department = new Department();
//        user.setId(dto.getId());
//        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword());
//        department.setId(dto.getDepartmentId());
//        department.setName(dto.getDepartmentName());
//        user.setDepartment(department);
//        return user;
//    }
}
