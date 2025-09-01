package com.leopoldo.ebook.ebook.dtos.User;

import java.util.List;
import com.leopoldo.ebook.ebook.dtos.Book.BookSumaryDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserLibraryDto {

    @NotBlank
    private String username;
    @NotBlank
    private List<BookSumaryDto> libraries;
}
