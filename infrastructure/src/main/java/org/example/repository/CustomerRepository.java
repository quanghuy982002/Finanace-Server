package org.example.repository;

import org.example.entity.Customer;
import org.example.request.CustomerSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //select new org.example.dto.ExampleDTO(e.id, e.name, e.code, e.status, e.createdDate, e.createdBy, e.modifiedDate, e.modifiedBy)
    //new dto
    @Query("SELECT c FROM Customer c WHERE (:#{#request.code} IS NULL OR c.code LIKE %:#{#request.code}%)" +
            " AND (:#{#request.name} IS NULL OR c.name LIKE %:#{#request.name}%)")
    Page<Customer> searchCustomerByCodeAndName(@Param("request") CustomerSearchRequest request, Pageable pageable);
}
