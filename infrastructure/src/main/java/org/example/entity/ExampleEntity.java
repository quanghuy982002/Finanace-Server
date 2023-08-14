package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "example")
@Getter
@Setter
public class ExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_time", nullable = false, insertable = false)
    private LocalDateTime createdTime;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_time", nullable = true)
    private LocalDateTime updatedTime;

//    @Column(name = "delete_by", length = 255)
//    private String deletedBy;

    @Column(name = "deleted_time", nullable = true)
    private LocalDateTime deletedTime;
}
