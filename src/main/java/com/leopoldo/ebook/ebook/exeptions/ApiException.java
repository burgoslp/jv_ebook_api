package com.leopoldo.ebook.ebook.exeptions;

import java.util.List;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    private Integer code;
    private HttpStatus httpStatus;
    private List<String> data;


    public ApiException(ApiError apiError) {
        super(apiError.getMessage());

        this.code = apiError.getCode();
        this.httpStatus = apiError.getHttpStatus();
        this.data = apiError.getData();
    }


    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }


    public List<String> getData() {
        return data;
    }


    public void setData(List<String> data) {
        this.data = data;
    }

    

}
