package com.leopoldo.ebook.ebook.dtos.category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import validations.UniqueCategoryName;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryCreateDto {

    @NotBlank
    @UniqueCategoryName
    private String name;
    @NotBlank
    private String description;
}
