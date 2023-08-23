package org.example.service.role;

import org.example.dto.PageResponse;
import org.example.entity.Role;
import org.example.request.role.RoleRequest;
import org.example.request.role.RoleSearchRequest;
import org.springframework.http.ResponseEntity;

public interface RoleService {
    ResponseEntity<?> getRole();

    ResponseEntity<?> createRole(RoleRequest request);

    ResponseEntity<?> updateRole(Integer id, RoleRequest request);

    ResponseEntity<?> deleteRole(Integer id);

    ResponseEntity<?> getStaffsByRoleId(Integer id);

    ResponseEntity<?> getRoleById(Integer id);

    PageResponse<Role> searchRole(RoleSearchRequest request);

}
