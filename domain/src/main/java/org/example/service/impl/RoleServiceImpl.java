package org.example.service.impl;

import org.example.entity.Role;
import org.example.repository.RoleRepository;
import org.example.repository.StaffRepository;
import org.example.request.role.RoleRequest;
import org.example.service.role.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final StaffRepository staffRepository;

    public RoleServiceImpl(RoleRepository repository, StaffRepository staffRepository) {
        this.repository = repository;
        this.staffRepository = staffRepository;
    }

    @Override
    public ResponseEntity<?> getRole() {
        List<Role> listRole = this.repository.findAll();
        return new ResponseEntity<>(listRole, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createRole(RoleRequest request) {
        if(repository.existsByCode(request.getCode())){
            return new ResponseEntity<>("Code existed", HttpStatus.BAD_REQUEST);
        }
            Role newRole = new Role();
            newRole.setCode(request.getCode());
            newRole.setRoleProject(request.getRoleProject());
            newRole.setRoleTitle(request.getRoleTitle());
            newRole.setStatus(request.getStatus());
            this.repository.save(newRole);
            return new ResponseEntity<>(newRole,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateRole(Integer id, RoleRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteRole(Integer id) {
        return null;
    }
}
