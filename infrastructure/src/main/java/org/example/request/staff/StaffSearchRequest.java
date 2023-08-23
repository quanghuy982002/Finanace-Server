package org.example.request.staff;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.PageRequest;
@Data
@NoArgsConstructor
public class StaffSearchRequest extends PageRequest {
    private String name = "";
    private String code = "";
    private String email = "";
}
