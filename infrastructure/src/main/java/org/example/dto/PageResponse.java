package org.example.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageResponse<T> extends Response<List<T>>{
    private long totalRecord;

    public PageResponse() {
    }

    public PageResponse(List<T> data) {
        super(data);
    }

    public PageResponse(List<T> data, long totalRecord) {
        this.setData(data);
        this.setTotalRecord(totalRecord);
    }
}
