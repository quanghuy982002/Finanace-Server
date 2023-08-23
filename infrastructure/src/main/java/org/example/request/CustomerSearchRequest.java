package org.example.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.PageRequest;


@Data
@NoArgsConstructor
public class CustomerSearchRequest extends PageRequest {
    private String code = "";
    private String name = "";

}
