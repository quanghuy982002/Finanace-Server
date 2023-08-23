package org.example.controller;

import org.example.request.role.RoleRequest;
import org.example.service.impl.RoleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@CrossOrigin("*")
public class RoleController {
    private final RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getRoles(){
        return this.roleService.getRole();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRole(@RequestBody RoleRequest request){
        return this.roleService.createRole(request);
    }
}
