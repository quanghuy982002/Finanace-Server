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
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private String status;
    private String groupName;
    private String avatarImage;

    @CreatedDate
    @Column(name = "created_time", nullable = false, insertable = false)
    private LocalDateTime createdTime;


    @LastModifiedDate
    @Column(name = "updated_time", nullable = true)
    private LocalDateTime updatedTime;
}
