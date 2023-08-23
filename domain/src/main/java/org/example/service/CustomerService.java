package org.example.service;

import org.example.dto.CustomerDTO;
import org.example.dto.CustomerDetailsDTO;
import org.example.dto.PageResponse;
import org.example.entity.Customer;
import org.example.request.CustomerSearchRequest;

import java.util.List;

public interface CustomerService {

    PageResponse<Customer> searchCustomerByCode(CustomerSearchRequest request);

    List<CustomerDTO> getAllCustomers();

    CustomerDetailsDTO getCustomerDetails(Long customerId);
}
