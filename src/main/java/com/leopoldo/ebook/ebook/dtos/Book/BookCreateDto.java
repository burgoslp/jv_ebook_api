package com.leopoldo.ebook.ebook.dtos.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookCreateDto {

    @NotBlank
    private String title;
    @NotNull
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "la fecha de publicación debe tener el siguiente formato YYYY-MM-DD")
    private String publicationDate;
    @NotBlank
    private String publisher;
    @NotBlank
    private String isbn;
    @NotBlank
    private String synopsis;
    @NotBlank
    private String cover;
    @NotNull
    private Integer available;

}
