package com.leopoldo.ebook.ebook.dtos.Author;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.leopoldo.ebook.ebook.models.Book;
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
public class AuthorDetailsDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotNull
    private LocalDate birthDate;
    @NotBlank
    private String nationality;
    @NotBlank
    private String biography;
    @NotNull
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //campo opcional
    private String image;
    private List<Book> books;
}
