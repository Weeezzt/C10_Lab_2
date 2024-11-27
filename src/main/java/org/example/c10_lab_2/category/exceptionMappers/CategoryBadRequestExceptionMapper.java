package org.example.c10_lab_2.category.exceptionMappers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public class CategoryBadRequestExceptionMapper extends RuntimeException {
        public CategoryBadRequestExceptionMapper(String message) {
            super(message);
        }
    }

