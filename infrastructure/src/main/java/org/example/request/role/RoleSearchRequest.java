package org.example.request.role;

import lombok.Data;
import org.example.dto.PageRequest;

@Data
public class RoleSearchRequest extends PageRequest {
    private String code;
}
