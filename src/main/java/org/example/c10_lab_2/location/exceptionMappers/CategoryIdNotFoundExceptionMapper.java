package org.example.c10_lab_2.location.exceptionMappers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CategoryIdNotFoundExceptionMapper extends RuntimeException {

    public CategoryIdNotFoundExceptionMapper(int id) {
        super("Category with id " + id + " not found");
    }
}





