package com.vinisolon.springbootuserdepartment.repositories;

import com.vinisolon.springbootuserdepartment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
