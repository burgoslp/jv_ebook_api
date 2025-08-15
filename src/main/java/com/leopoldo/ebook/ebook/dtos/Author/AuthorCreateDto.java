package com.leopoldo.ebook.ebook.dtos.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "la fecha de nacimiento debe tener el siguiente formato YYYY-MM-DD")
    private String birthDate;
    @NotBlank
    private String nationality;
    @NotBlank
    private String biography;
    //campo opcional
    private String image;
}
