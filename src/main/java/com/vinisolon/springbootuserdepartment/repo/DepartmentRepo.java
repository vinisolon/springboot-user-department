package com.vinisolon.springbootuserdepartment.repo;

import com.vinisolon.springbootuserdepartment.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
