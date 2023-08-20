package org.example.controller;

import org.example.dto.CustomerDTO;
import org.example.dto.CustomerDetailsDTO;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerDetailsDTO> getCustomerDetails(@PathVariable Long customerId) {
        CustomerDetailsDTO customerDetails = customerService.getCustomerDetails(customerId);
        if (customerDetails == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerDetails);
    }

//    @GetMapping("/customer/{id}")
//    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
//        CustomerDTO customerDTO = customerService.getCustomerById(id);
//        if (customerDTO != null) {
//            return new ResponseEntity<>(customerDTO, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/customer")
//    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
//        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
//        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
//    }
//
//    @PutMapping("customer/{id}")
//    public ResponseEntity<CustomerDTO> updateCustomer(
//            @PathVariable int id,
//            @RequestBody CustomerDTO customerDTO) {
//        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
//        if (updatedCustomer != null) {
//            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("customer/{id}")
//    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
//        customerService.deleteCustomer(id);
//        return new ResponseEntity<>("Customer with ID " + id + " has been successfully deleted.", HttpStatus.OK);
//    }
}
