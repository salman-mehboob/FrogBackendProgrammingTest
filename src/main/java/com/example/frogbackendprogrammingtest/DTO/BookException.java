package com.example.frogbackendprogrammingtest.DTO;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookException extends RuntimeException {
    private String name;
    private String field;
    private Object value;

    public BookException( String name, String field, Object value) {
        super(String.format("%s not found with %s : '%s'", name, field, value));
        this.name = name;
        this.field = field;
        this.value = value;
    }

    public String getResourceName() {
        return name;
    }
    public String getFieldName() {
        return field;
    }
    public Object getFieldValue() {
        return value;
    }
}
