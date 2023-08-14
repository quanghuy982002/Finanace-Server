package org.example.controller;

import org.example.dto.PageResponse;
import org.example.dto.Response;
import org.example.entity.ExampleEntity;
import org.example.request.ExampleRequest;
import org.example.request.ExampleSearchRequest;
import org.example.service.ExampleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/example")
public class ExampleController {
    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping("/search")
    public PageResponse<ExampleEntity> searchExample(@RequestBody ExampleSearchRequest request) {
        return exampleService.searchExample(request);
    }

    @PostMapping("/insert")
    public Response<ExampleEntity> insertExample(@RequestBody ExampleRequest request) {
        return exampleService.insertExample(request);
    }
    @PutMapping("/update")
    public Response<ExampleEntity> updateExample(@RequestBody ExampleRequest request) {
        return exampleService.updateExample(request);
    }
}
