package org.example.service;

import org.example.dto.CustomerDTO;
import org.example.dto.CustomerDetailsDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDetailsDTO getCustomerDetails(Long customerId);
//    CustomerDTO getCustomerById(int id);
//    CustomerDTO createCustomer(CustomerDTO customerDTO);
//    CustomerDTO updateCustomer(int id, CustomerDTO customerDTO);
//
//    void deleteCustomer(int id);
}
