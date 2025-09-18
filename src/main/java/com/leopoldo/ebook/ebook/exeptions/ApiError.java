package com.leopoldo.ebook.ebook.exeptions;
import java.util.List;
import org.springframework.http.HttpStatus;

public enum ApiError {

    ARGUMENTS_VALIDATION_ERROR(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "Algunos de los argumentos ingresados no son correctos",List.of("")),
    USER_BYID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró el usuario por id",List.of("")),
    BOOK_NOT_LIKED(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "El usuario no ha dado like a este libro",List.of("")),
    BOOK_BYID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró el libro por id",List.of("")),
    BOOK_ALREADY_LIKED(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "El usuario ya tiene registrado su like en este libro",List.of("")),
    BOOK_ALREADY_EXISTS(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "El author ya tiene asociado el libro",List.of("")),
    BOOK_NOT_FOUND_IN_AUTHOR(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "El author no tiene asociado el libro",List.of("")),
    BOOK_ALREADY_IN_LIBRARY(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "El libro ya esta agregado a la librería del usuario",List.of("")),
    BOOK_NOT_IN_LIBRARY(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "El libro no se encuentra agregado a la librería del usuario",List.of("")),
    BOOK_NOT_AVAILABLE(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "El libro no tiene existencias disponibles en este momento",List.of("")),
    AUTHOR_BYID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró el autor por id",List.of("")),
    CATEGORY_BYID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró la categoría por id",List.of("")),
    CATEGORY_ALREADY_EXISTS(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "La categoría ya está asociada al libro",List.of("")),
    ROLE_BYNAME_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró el rol por nombre",List.of("")),
    LOAN_BYID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró el prestamo solicitado",List.of("")),
    LOAN_VALIDATION_ERROR(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "El prestamo solicitado no ha sido aprovado o fué descartado",List.of("")),
    LOAN_VALIDATION_REJECTED_ERROR(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "El prestamo solicitado ya ha sido aprovado o fué descartado",List.of("")),
    LOAN_BYUSERID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontraron prestamos para el usuario indicado",List.of(""));

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
