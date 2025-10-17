package com.leopoldo.ebook.ebook.dtos.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorCreateDto {

    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String birthDate;
    @NotNull
    private Long nationalityId;
    @NotBlank
    private String biography;
    //campo opcional
    private String image;
}
