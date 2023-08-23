package org.example.repository;

import org.example.entity.Staff;
import org.example.request.staff.StaffSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

//    @Query("SELECT s FROM Staff s WHERE s.code like  %:#{#request.code}% and s.name like  %:#{#request.name}% and s.email like %:#{#request.email}% ")
//    Page<Staff> searchStaff(@Param("request") StaffSearchRequest request, Pageable pageable);

    @Query("SELECT s FROM Staff s WHERE (:#{#request.code} IS NULL OR s.code LIKE %:#{#request.code}%)" +
            " AND (:#{#request.name} IS NULL OR s.name LIKE %:#{#request.name}%)" + " AND (:#{#request.email} IS NULL OR s.name LIKE %:#{#request.email}%)")
    Page<Staff> searchStaff(@Param("request") StaffSearchRequest request, Pageable pageable);

    boolean existsByCode(String code);

    Staff getStaffById(Integer staffId);
//    @Query("SELECT s FROM Staff s WHERE s.name like  %:#{#request.name}% ")
//    Page<Staff> searchByName(@Param("request") String name, Pageable pageable);
//    @Query("SELECT s FROM Staff s WHERE s.email like  %:#{#request.email}% ")
//    Page<Staff> searchByEmail(@Param("request") String email, Pageable pageable);


}
