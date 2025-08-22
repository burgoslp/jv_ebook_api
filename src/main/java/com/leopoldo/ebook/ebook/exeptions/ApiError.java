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
    AUTHOR_BYID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró el autor por id",List.of("")),
    CATEGORY_BYID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, "No se encontró la categoría por id",List.of("")),
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
