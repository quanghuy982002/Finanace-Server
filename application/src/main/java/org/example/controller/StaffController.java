package org.example.controller;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.dto.PageResponse;
import org.example.dto.StaffDTO;
import org.example.entity.Staff;
import org.example.request.staff.StaffRequest;
import org.example.request.staff.StaffSearchRequest;
import org.example.service.impl.StaffServiceImpl;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin("*")
public class StaffController {
    private final StaffServiceImpl service;

    public StaffController(StaffServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/search")
    public PageResponse<Staff> searchStaff(@RequestBody StaffSearchRequest request) {
        return service.searchStaff(request);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertStaff(@RequestBody StaffRequest request) {
        return service.insertStaff(request);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllStaff() {
        return service.getAllStaff();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStaffById(@PathVariable Integer id) {
        return service.getStaffById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStaff(@RequestBody StaffRequest request) {
        return service.updateStaff(request);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<?> getRole(@PathVariable Integer id) {
        return service.getRoleById(id);
    }

    @GetMapping("/staff/export")
    public ResponseEntity<ByteArrayResource> exportCustomersToExcel() throws IOException {
        List<StaffDTO> staffs = service.getStaffs();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Customers");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Nhân viên");
        headerRow.createCell(2).setCellValue("Email");
        headerRow.createCell(3).setCellValue("Đơn vị");
        headerRow.createCell(4).setCellValue("Chức năng");
        headerRow.createCell(5).setCellValue("Trạng thái");

        int rowNum = 1;
        for (StaffDTO staff : staffs) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(staff.getCode());
            row.createCell(1).setCellValue(staff.getName());
            row.createCell(2).setCellValue(staff.getEmail());
            row.createCell(3).setCellValue(staff.getDepartmentName());
            row.createCell(4).setCellValue(staff.getRoleName());
            row.createCell(5).setCellValue(staff.getStatus());
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=customers.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .body(resource);
    }
}
