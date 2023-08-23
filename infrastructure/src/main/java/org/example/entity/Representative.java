package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "representative")
@Data
public class Representative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String name;
    private String gender;
    private String phoneNumber;
    private String position;
    private String avatarImage;
}
