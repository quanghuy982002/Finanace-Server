package org.example.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.PageRequest;

@Data
@NoArgsConstructor
public class ExampleSearchRequest extends PageRequest {
    private String name;

}
