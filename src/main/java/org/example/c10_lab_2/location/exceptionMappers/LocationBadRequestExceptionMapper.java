package org.example.c10_lab_2.location.exceptionMappers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LocationBadRequestExceptionMapper extends RuntimeException {

    public LocationBadRequestExceptionMapper(String name) {
        super("Location with the name " + name + " already exists");
    }
}
