package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageRequest {

    private static final String DEFAULT_FIELD_SORT = "id";

    private int page = 1;
    private int size = 100;
    private String keyword;

    private List<String> sorts;

    public int getSize() {
        return size == -1 ? Integer.MAX_VALUE : size;
    }

    public void setSize(int size) {
        this.size = size == -1 ? Integer.MAX_VALUE : size;
    }

    @JsonIgnore
    @JsonProperty("jsonIgnore")
    public Sort getSorts() {
        List<Sort.Order> orders = new ArrayList<>();
        if (sorts == null || sorts.isEmpty()) {
            return getDefaultSort();
        }
        for (String item : sorts) {
            if (item == null || item.trim().isEmpty()) {
                continue;
            } else {
                String[] sortProperties = item.split("-");
                String property = sortProperties.length >= 1 ? sortProperties[0] : DEFAULT_FIELD_SORT;
                Sort.Direction direction = sortProperties.length == 2 ? Sort.Direction.fromString(sortProperties[1]) : Sort.Direction.ASC;
                Sort.Order order = new Sort.Order(direction, getProperty(property));
                orders.add(order);
            }
        }
        return Sort.by(orders);
    }

    protected String getProperty(String property) {
        return property;
    }

    protected Sort getDefaultSort() {
        return Sort.by(Sort.Direction.DESC, "createdTime");
    }

    @JsonIgnore
    public Pageable getPageable() {
        return org.springframework.data.domain.PageRequest.of(page - 1, size, getSorts());
    }
}
