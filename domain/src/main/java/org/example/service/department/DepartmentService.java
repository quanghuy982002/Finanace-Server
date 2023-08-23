package org.example.service.department;


import org.example.request.department.DepartmentRequest;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
    ResponseEntity<?> createDepartment(DepartmentRequest request);
    ResponseEntity<?> readDepartment();
    ResponseEntity<?> updateDepartment(Integer id, DepartmentRequest request);

    ResponseEntity<?> deleteDepartment(Integer id);
}
