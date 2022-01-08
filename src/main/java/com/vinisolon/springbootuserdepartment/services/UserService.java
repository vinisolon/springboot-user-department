package com.vinisolon.springbootuserdepartment.services;

import com.vinisolon.springbootuserdepartment.domain.User;
import com.vinisolon.springbootuserdepartment.dto.UserDepartmentInsertDTO;
import com.vinisolon.springbootuserdepartment.dto.UserDepartmentViewDTO;
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

    public List<UserDepartmentViewDTO> getAllUsersDepartment() {
        return repo.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public UserDepartmentViewDTO getUserDepartment(Long id) {
        return entityToDto(repo.findById(id).orElseThrow());
    }

    public User insert(UserDepartmentInsertDTO obj) {
        // TODO: Corrigir insert. O user não está gerando ID corretamente.
        return repo.save(dtoToEntity(obj));
    }

    // #Convert

    private UserDepartmentViewDTO entityToDto(User user) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(user, UserDepartmentViewDTO.class);
    }

    private User dtoToEntity(UserDepartmentViewDTO dto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(dto, User.class);
    }

    private User dtoToEntity(UserDepartmentInsertDTO dto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(dto, User.class);
    }
}
