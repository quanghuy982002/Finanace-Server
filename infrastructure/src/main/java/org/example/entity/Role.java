package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "role_title", nullable = false)
    private String roleTitle;

    @Column(name = "role_project", nullable = false)
    private String roleProject;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean status;
    @JsonBackReference
    @OneToMany(mappedBy = "id")
    private List<Staff> staff;
}
