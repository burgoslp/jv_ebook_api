package com.leopoldo.ebook.ebook.dtos.Book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookByCategoryDto {

    private String categoryName;
    private Long totalBooks;

}
