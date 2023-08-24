package org.example.service.impl;

import org.example.dto.PageResponse;
import org.example.dto.StaffDTO;
import org.example.entity.Staff;
import org.example.exception.CommonException;
import org.example.repository.DepartmentRepository;
import org.example.repository.RoleRepository;
import org.example.repository.StaffRepository;
import org.example.request.staff.StaffRequest;
import org.example.request.staff.StaffSearchRequest;
import org.example.service.staff.StaffService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository repository;
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;

    public StaffServiceImpl(StaffRepository repository, DepartmentRepository departmentRepository, RoleRepository roleRepository) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public PageResponse<Staff> searchStaff(StaffSearchRequest request) {
//        request.setCode(request.getCode().isEmpty() ? null : request.getCode());
//        request.setName(request.getName().isEmpty() ? null : request.getName());
//        request.setEmail(request.getEmail().isEmpty() ? null : request.getEmail());
        Page<Staff> page = repository.searchStaff(request, request.getPageable());
        return new PageResponse<>(page.getContent(), page.getTotalElements());
    }

    @Override
    public ResponseEntity<?> insertStaff(StaffRequest request) {
        if (repository.existsByCode(request.getCode()) || repository.existsByEmail(request.getCode())) {
            return new ResponseEntity<>("existed", HttpStatus.BAD_REQUEST);
        }
        Staff staff = new Staff();
        staff.setName(request.getName());
        staff.setCode(request.getCode());
        staff.setEmail(request.getEmail());
        staff.setPicture(request.getPicture());
        staff.setDepartment(departmentRepository.getById(request.getDepartment()));
        staff.setRole(roleRepository.getReferenceById(request.getRoleId()));
        staff.setStatus(request.getStatus());
        repository.save(staff);
        return new ResponseEntity<>("inserted", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllStaff() {
        List<Staff> staff = repository.findAll();
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getStaffById(Integer id) {
        Staff staff = repository.getStaffById(id);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateStaff(StaffRequest request) {
        if(request.getCode() == null) {
            throw new CommonException(HttpStatus.BAD_REQUEST, "Please enter");
        }
        Staff staff = repository.findById(request.getId()).orElseThrow(()-> new CommonException(HttpStatus.NOT_FOUND, "Not existed"));
        staff.setName(request.getName());
        staff.setCode(request.getCode());
        staff.setEmail(request.getEmail());
        staff.setPicture(request.getPicture());
        staff.setDepartment(departmentRepository.getById(request.getDepartment()));
        staff.setRole(roleRepository.getReferenceById(request.getRoleId()));
        staff.setStatus(request.getStatus());
        repository.save(staff);
        return new ResponseEntity<>("updated", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> getRoleById(Integer id) {
        return new ResponseEntity<>(repository.getStaffById(id).getRole(), HttpStatus.OK);
    }

    @Override
    public List<StaffDTO> getStaffs() {
        List<Staff> staffs = repository.findAll();

        List<StaffDTO> staffDTOS = new ArrayList<>();

        for (Staff staff: staffs)
        {
            StaffDTO staffDTO = new StaffDTO();
            staffDTO.setId(staff.getId());
            staffDTO.setCode(staff.getCode());
            staffDTO.setName(staff.getName());
            staffDTO.setEmail(staff.getEmail());
            staffDTO.setDepartmentName(staff.getDepartment().getName());
            staffDTO.setRoleName(staff.getRole().getRoleTitle());
            staffDTO.setStatus(staff.getStatus());
            staffDTOS.add(staffDTO);
        }
        return staffDTOS;
    }
}
