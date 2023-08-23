package org.example.service.impl;

import org.example.entity.Department;
import org.example.repository.DepartmentRepository;
import org.example.request.department.DepartmentRequest;
import org.example.service.department.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }
    @Override
    public ResponseEntity<?> createDepartment(DepartmentRequest request) {
        if(repository.existsByName(request.getName())) {
            return new ResponseEntity<>("name existed", HttpStatus.BAD_REQUEST);
        }
        Department newDepartment = new Department();
        newDepartment.setName(request.getName());
//        newDepartment.setStaff(request.getStaff());
        repository.save(newDepartment);
        return new ResponseEntity<>("saved", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> readDepartment() {
        List<Department> listD = repository.findAll();
        return new ResponseEntity<>(listD, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateDepartment(Integer id, DepartmentRequest request) {
        Department temp = new Department();
        if(repository.existsById(id)) {
            temp = repository.getById(id);
            temp.setName(request.getName());
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("not existed", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteDepartment(Integer id) {
        Department temp = new Department();
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("not existed", HttpStatus.NOT_FOUND);
    }
}
