package org.example.service.impl;

import org.example.dto.CustomerDTO;
import org.example.dto.CustomerDetailsDTO;
import org.example.dto.RepresentativeDTO;
import org.example.entity.Customer;
import org.example.entity.CustomerDetails;
import org.example.entity.Representative;
import org.example.repository.CustomerDetailsRepository;
import org.example.repository.CustomerRepository;
import org.example.repository.RepresentativeRepository;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDetailsRepository customerDetailsRepository;
    private final RepresentativeRepository representativeRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerDetailsRepository customerDetailsRepository,
                               RepresentativeRepository representativeRepository) {
        this.customerRepository = customerRepository;
        this.customerDetailsRepository = customerDetailsRepository;
        this.representativeRepository = representativeRepository;
    }

    //    modelMapper
    private CustomerDTO mapToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setCode(customer.getCode());
        customerDTO.setName(customer.getName());
        customerDTO.setGroupName(customer.getGroupName());
        customerDTO.setStatus(customer.getStatus());
        customerDTO.setAvatarImage(customer.getAvatarImage());
        return customerDTO;
    }

    private Customer mapToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setCode(customerDTO.getCode());
        customer.setName(customerDTO.getName());
        customer.setGroupName(customerDTO.getGroupName());
        customer.setStatus(customerDTO.getStatus());
        customer.setAvatarImage(customerDTO.getAvatarImage());
        return customer;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOs = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setCode(customer.getCode());
            customerDTO.setName(customer.getName());
            customerDTO.setGroupName(customer.getGroupName());
            customerDTO.setStatus(customer.getStatus());
            customerDTO.setAvatarImage(customer.getAvatarImage());
            customerDTOs.add(customerDTO);
        }
        return customerDTOs;
    }

    @Override
    public CustomerDetailsDTO getCustomerDetails(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            return null;
        }
        return mapToCustomerDetailsDTO(customer);
    }

    private CustomerDetailsDTO mapToCustomerDetailsDTO(Customer customer) {
        CustomerDetails customerDetails = customerDetailsRepository.findByCustomer(customer);
        List<Representative> representatives = representativeRepository.findByCustomer(customer);

        CustomerDetailsDTO detailsDTO = new CustomerDetailsDTO();

        detailsDTO.setId(customer.getId());
        detailsDTO.setName(customer.getName());
        detailsDTO.setCode(customer.getCode());
        detailsDTO.setGroupName(customer.getGroupName());
        detailsDTO.setStatus(customer.getStatus());
        detailsDTO.setAvatarImage(customer.getAvatarImage());

        detailsDTO.setPhoneNumber(customerDetails.getPhoneNumber());
        detailsDTO.setTaxId(customerDetails.getTaxId());
        detailsDTO.setFax(customerDetails.getFax());
        detailsDTO.setEmail(customerDetails.getEmail());
        detailsDTO.setAddress(customerDetails.getAddress());
        detailsDTO.setBankAccountNumber(customerDetails.getBankAccountNumber());
        detailsDTO.setBankAccountNumber(customerDetails.getBankAccountNumber());
        detailsDTO.setBankName(customerDetails.getBankName());
        detailsDTO.setBankBranch(customerDetails.getBankBranch());

        List<RepresentativeDTO> representativeDTOs = new ArrayList<>();
        for (Representative representative : representatives) {
            RepresentativeDTO representativeDTO = new RepresentativeDTO();
            representativeDTO.setGender(representative.getGender());
            representativeDTO.setName(representative.getName());
            representativeDTO.setPhoneNumber(representative.getPhoneNumber());
            representativeDTO.setPosition(representative.getPosition());
            representativeDTO.setAvatarImage(representative.getAvatarImage());
            representativeDTOs.add(representativeDTO);
        }
        detailsDTO.setRepresentatives(representativeDTOs);

        return detailsDTO;
    }

//    @Override
//    public CustomerDTO getCustomerById(int id) {
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//        return customerOptional.map(this::mapToDTO).orElse(null);
//    }

//    @Override
//    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
//        Customer customer = mapToEntity(customerDTO);
//        customer = customerRepository.save(customer);
//        return mapToDTO(customer);
//    }
//
//    @Override
//    public CustomerDTO updateCustomer(int id, CustomerDTO customerDTO) {
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//        if (customerOptional.isPresent()) {
//            Customer customerToUpdate = customerOptional.get();
//            customerToUpdate.setCode(customerDTO.getCode());
//            customerToUpdate.setName(customerDTO.getName());
//            customerToUpdate = customerRepository.save(customerToUpdate);
//            return mapToDTO(customerToUpdate);
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteCustomer(int id) {
//        customerRepository.deleteById(id);
//    }
}
