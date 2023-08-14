package org.example.service;

import org.example.dto.PageResponse;
import org.example.dto.Response;
import org.example.entity.ExampleEntity;
import org.example.request.ExampleRequest;
import org.example.request.ExampleSearchRequest;

public interface ExampleService {
    PageResponse<ExampleEntity> searchExample(ExampleSearchRequest request);

    Response<ExampleEntity> insertExample(ExampleRequest request);

    Response<ExampleEntity> updateExample(ExampleRequest request);
}
