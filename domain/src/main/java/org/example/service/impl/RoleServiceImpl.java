package org.example.service.impl;

import org.example.dto.PageResponse;
import org.example.entity.Role;
import org.example.entity.Staff;
import org.example.repository.RoleRepository;
import org.example.repository.StaffRepository;
import org.example.request.role.RoleRequest;
import org.example.request.role.RoleSearchRequest;
import org.example.service.role.RoleService;
import org.springframework.data.domain.Page;
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
        if(repository.existsById(id)){
            Role newRole = new Role();
            newRole = repository.findById(id).get();
            newRole.setCode(request.getCode());
            newRole.setRoleProject(request.getRoleProject());
            newRole.setRoleTitle(request.getRoleTitle());
            newRole.setStatus(request.getStatus());
            this.repository.save(newRole);
            return new ResponseEntity<>(newRole,HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteRole(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new ResponseEntity<>("Removed", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> getStaffsByRoleId(Integer id) {
        Role role = repository.findById(id).get();
        List<Staff> staffs = staffRepository.getStaffByRole(role);
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getRoleById(Integer id) {
        return new ResponseEntity<>(repository.findById(id).get(),HttpStatus.OK);
    }

    @Override
    public PageResponse<Role> searchRole(RoleSearchRequest request) {
        Page<Role> page = repository.searchRole(request, request.getPageable());
        return new PageResponse<>(page.getContent(), page.getTotalElements());
    }
}
