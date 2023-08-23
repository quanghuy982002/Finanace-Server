package org.example.controller;

import org.example.dto.PageResponse;
import org.example.dto.Response;
import org.example.entity.Role;
import org.example.request.role.RoleRequest;
import org.example.request.role.RoleSearchRequest;
import org.example.service.impl.RoleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = "*")
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

    @GetMapping("/get-staffs/{id}")
    public ResponseEntity<?> getStaffs(@PathVariable Integer id){
        return this.roleService.getStaffsByRoleId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Integer id){
        return this.roleService.getRoleById(id);
    }

    @PostMapping("/search")
    public PageResponse<Role> searchRole(@RequestBody RoleSearchRequest request){
        return roleService.searchRole(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Integer id, @RequestBody RoleRequest request){
        return this.roleService.updateRole(id,request);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id){
        return this.roleService.deleteRole(id);
    }
}
