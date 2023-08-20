package org.example.repository;

import org.example.entity.Customer;
import org.example.entity.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepresentativeRepository extends JpaRepository<Representative, Long> {
    List<Representative> findByCustomer(Customer customer);
}
