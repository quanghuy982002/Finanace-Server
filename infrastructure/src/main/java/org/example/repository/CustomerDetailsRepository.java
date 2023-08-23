package org.example.repository;

import org.example.entity.Customer;
import org.example.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
    CustomerDetails findByCustomer(Customer customer);
}
