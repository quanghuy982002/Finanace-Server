package org.example.service.role;

import org.example.request.role.RoleRequest;
import org.springframework.http.ResponseEntity;

public interface RoleService {
    ResponseEntity<?> getRole();

    ResponseEntity<?> createRole(RoleRequest request);

    ResponseEntity<?> updateRole(Integer id, RoleRequest request);

    ResponseEntity<?> deleteRole(Integer id);
}
