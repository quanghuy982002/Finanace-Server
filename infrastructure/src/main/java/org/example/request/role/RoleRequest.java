package org.example.request.role;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RoleRequest {
    private String code;
    private String roleTitle;
    private String roleProject;
    private Boolean status;

}
