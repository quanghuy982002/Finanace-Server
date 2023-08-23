package org.example.controller;

import org.example.request.department.DepartmentRequest;
import org.example.service.impl.DepartmentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentServiceImpl service;

    public DepartmentController(DepartmentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDepartment(@RequestBody @Validated DepartmentRequest request) {
        return service.createDepartment(request);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getDepartment() {
        return service.readDepartment();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentRequest request) {
        return service.updateDepartment(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer id) {
        return service.deleteDepartment(id);
    }
}
