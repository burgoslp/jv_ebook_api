package com.leopoldo.ebook.ebook.exeptions;
import java.util.List;
import org.springframework.http.HttpStatus;

public enum ApiError {

    ARGUMENTS_VALIDATION_ERROR(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "Algunos de los valores ingresados no son correctos",List.of("")),
    USER_BYID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró el usuario por id",List.of("")),
    ROLE_BYNAME_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró el rol por nombre",List.of(""));

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;
    private final List<String> data;


    private ApiError(Integer code, HttpStatus httpStatus, String message, List<String> data) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }


    public Integer getCode() {
        return code;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


    public String getMessage() {
        return message;
    }


    public List<String> getData() {
        return data;
    }

    

}
