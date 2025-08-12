package com.leopoldo.ebook.ebook.exeptions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<JsonApiResponse> handleApiException(ApiException ex){
        return ResponseEntity.status(ex.getHttpStatus()).body(JsonApiResponse.builder().code(ex.getCode()).message(ex.getMessage()).data(ex.getData()).build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<JsonApiResponse> handleArgumentNotValidException(MethodArgumentNotValidException ex){

        List<String> errors= new ArrayList<>();

        ex.getFieldErrors().forEach(fieldError -> {
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        });
        
        return ResponseEntity.badRequest().body(JsonApiResponse.builder()
                .code(ex.getStatusCode().value())
                .message(ApiError.ARGUMENTS_VALIDATION_ERROR.getMessage())
                .data(errors).build());

    }

}
