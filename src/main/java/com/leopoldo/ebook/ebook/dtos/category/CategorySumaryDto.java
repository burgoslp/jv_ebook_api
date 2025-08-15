package com.leopoldo.ebook.ebook.dtos.category;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategorySumaryDto {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
