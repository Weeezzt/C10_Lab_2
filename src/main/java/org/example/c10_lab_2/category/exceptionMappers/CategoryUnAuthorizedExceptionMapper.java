package org.example.c10_lab_2.category.exceptionMappers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public class CategoryUnAuthorizedExceptionMapper extends RuntimeException {
        public CategoryUnAuthorizedExceptionMapper(String message) {
            super(message);
        }
    }


