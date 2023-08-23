package org.example.request.staff;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StaffRequest {
    private Integer id;
    private String name;
    private String code;
    private String email;
    private String picture;
    private Integer department;
    private Integer roleId;
    private Boolean status;
}
