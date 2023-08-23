package org.example.repository;

import org.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department getById(Integer id);
    boolean existsById(Integer id);
    boolean existsByName(String name);
}
