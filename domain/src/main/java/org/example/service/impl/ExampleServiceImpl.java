package org.example.service.impl;

import org.example.dto.PageResponse;
import org.example.dto.Response;
import org.example.entity.ExampleEntity;
import org.example.exception.CommonException;
import org.example.repository.ExampleRepository;
import org.example.request.ExampleRequest;
import org.example.request.ExampleSearchRequest;
import org.example.service.ExampleService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;

    public ExampleServiceImpl(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    /**
     * @param request
     * @return
     */
    @Override
    public PageResponse<ExampleEntity> searchExample(ExampleSearchRequest request) {
        Page<ExampleEntity>
                page = exampleRepository.searchExample(request, request.getPageable());
        return new PageResponse<>(page.getContent(), page.getTotalElements());
    }

    /**
     * @param request
     * @return
     */
    @Override
    public Response<ExampleEntity> insertExample(ExampleRequest request) {
        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setName(request.getName());
        exampleEntity.setDescription(request.getDescription());
        ExampleEntity save = exampleRepository.save(exampleEntity);
        return new Response<>(save);
    }

    /**
     * @param request
     * @return
     */
    @Override
    public Response<ExampleEntity> updateExample(ExampleRequest request) {
        if (request.getId() == null) {
            throw new CommonException(HttpStatus.BAD_REQUEST, "Bắt buột nhập id");
        }
        ExampleEntity exampleEntity = exampleRepository.findById(request.getId())
                .orElseThrow(() -> new CommonException(HttpStatus.BAD_REQUEST, "Không tìm thấy"));
        exampleEntity.setName(request.getName());
        exampleEntity.setDescription(request.getDescription());
        ExampleEntity save = exampleRepository.save(exampleEntity);
        return new Response<>(save);
    }
}
