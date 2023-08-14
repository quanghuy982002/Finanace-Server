package org.example.repository;

import org.example.entity.ExampleEntity;
import org.example.request.ExampleSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity,Integer> {
    @Query("SELECT  ex FROM ExampleEntity ex WHERE ex.name like  %:#{#request.name}% ")
    Page<ExampleEntity> searchExample(@Param("request") ExampleSearchRequest request, Pageable pageable);
}
