package org.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "staff")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "picture")
    private String picture;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name= "department")
    private Department department;
    @Column(name = "status", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean status;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "role")
    private Role role;
    @CreatedDate
    @Column(name = "created_time", nullable = false, insertable = false)
    private LocalDateTime createdTime;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
