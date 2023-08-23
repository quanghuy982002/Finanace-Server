package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @OneToOne(fetch = FetchType.LAZY)
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
    private String note;

    @CreatedDate
    @Column(name = "created_time", nullable = false, insertable = false)
    private LocalDateTime createdTime;


    @LastModifiedDate
    @Column(name = "updated_time", nullable = true)
    private LocalDateTime updatedTime;
}
