package com.leopoldo.ebook.ebook.dtos.Author;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.leopoldo.ebook.ebook.dtos.Nationality.NationalitySumaryDto;

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
public class AuthorSumaryDto {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotNull
    private LocalDate birthDate;
    @NotBlank
    private String biography;
    @NotNull
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //campo opcional
    private String image;
    private NationalitySumaryDto nationality;

}
