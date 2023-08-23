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
        if(repository.existsByCode(request.getCode())){
            return new ResponseEntity<>("Code is already in use by another role", HttpStatus.BAD_REQUEST);
        }
        Role newRole = new Role();
        newRole.setCode(request.getCode());
        newRole.setRoleProject(request.getRoleProject());
        newRole.setRoleTitle(request.getRoleTitle());
        newRole.setStatus(request.getStatus());
        this.repository.save(newRole);
        return new ResponseEntity<>(newRole, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateRole(Integer id, RoleRequest request) {
        Role existingRole = repository.findById(id).orElse(null);
        
        if (existingRole != null) {
            Role roleWithSameCode = repository.findByCode(request.getCode());
            if (roleWithSameCode != null && !roleWithSameCode.getId().equals(id)) {
                return new ResponseEntity<>("Code is already in use by another role", HttpStatus.BAD_REQUEST);
            }
            
            existingRole.setCode(request.getCode());
            existingRole.setRoleProject(request.getRoleProject());
            existingRole.setRoleTitle(request.getRoleTitle());
            existingRole.setStatus(request.getStatus());
            
            repository.save(existingRole);
            return new ResponseEntity<>(existingRole, HttpStatus.OK);
        }
        
        return new ResponseEntity<>("Role not found", HttpStatus.NOT_FOUND);
    }
    
    @Override
    public ResponseEntity<?> deleteRole(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>("Removed", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> getStaffsByRoleId(Integer id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        Role role = repository.findById(id).get();
        List<Staff> staffs = staffRepository.getStaffByRole(role);
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getRoleById(Integer id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.OK);
    }

    @Override
    public PageResponse<Role> searchRole(RoleSearchRequest request) {
        Page<Role> page = repository.searchRole(request, request.getPageable());
        return new PageResponse<>(page.getContent(), page.getTotalElements());
    }
}
