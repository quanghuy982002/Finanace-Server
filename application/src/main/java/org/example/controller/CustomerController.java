package org.example.controller;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.dto.CustomerDTO;
import org.example.dto.CustomerDetailsDTO;
import org.example.dto.PageResponse;
import org.example.entity.Customer;
import org.example.request.CustomerSearchRequest;
import org.example.service.CustomerService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerDetailsDTO> getCustomerDetails(@PathVariable(name = "customerId") Long customerId) {
        CustomerDetailsDTO customerDetails = customerService.getCustomerDetails(customerId);
        if (customerDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

    @PostMapping("customer/search")
    public PageResponse<Customer> searchCustomerByCodeName(@RequestBody CustomerSearchRequest request) {
        return customerService.searchCustomerByCode(request);
    }

    //export excel .xlsx file
    @GetMapping("/customer/export")
    public ResponseEntity<ByteArrayResource> exportCustomersToExcel() throws IOException {
        List<CustomerDTO> customers = customerService.getAllCustomers();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Customers");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Code");
        headerRow.createCell(2).setCellValue("Tên khách hàng");
        headerRow.createCell(3).setCellValue("Trạng thái");
        headerRow.createCell(4).setCellValue("Nhóm khách hàng");
        headerRow.createCell(5).setCellValue("Đường dẫn ảnh đại diện");

        int rowNum = 1;
        for (CustomerDTO customer : customers) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(customer.getId());
            row.createCell(1).setCellValue(customer.getCode());
            row.createCell(2).setCellValue(customer.getName());
            row.createCell(3).setCellValue(customer.getStatus());
            row.createCell(4).setCellValue(customer.getGroupName());
            row.createCell(5).setCellValue(customer.getAvatarImage());
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
