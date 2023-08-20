package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String phoneNumber;
    private String taxId;
    private String email;
    private String fax;
    private String address;
    private String bankAccountNumber;
    private String bankName;
    private String bankBranch;
}
