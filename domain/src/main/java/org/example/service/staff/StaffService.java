package org.example.service.staff;

import org.example.dto.PageResponse;
import org.example.dto.StaffDTO;
import org.example.entity.Staff;
import org.example.request.staff.StaffRequest;
import org.example.request.staff.StaffSearchRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StaffService {
    PageResponse<Staff> searchStaff(StaffSearchRequest request);
    ResponseEntity<?> insertStaff(StaffRequest request);
    ResponseEntity<?> getAllStaff();
    ResponseEntity<?> getStaffById(Integer id);
    ResponseEntity<?> updateStaff(StaffRequest request);

    ResponseEntity<?> getRoleById(Integer id);

    List<StaffDTO> getStaffs();

}
