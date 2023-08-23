package org.example.repository;

import org.example.entity.Role;
import org.example.request.role.RoleSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    boolean existsByCode(String code);

    @Query("SELECT r FROM Role r WHERE (:#{#request.code} IS NULL OR r.code LIKE %:#{#request.code}%)" )
    Page<Role> searchRole(@Param("request") RoleSearchRequest request, Pageable pageable);

}
