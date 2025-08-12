package com.leopoldo.ebook.ebook.dtos.Json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JsonApiResponse {
    private Integer code;
    private String message;
    private Object data;
}
