package com.leopoldo.ebook.ebook.dtos.Book;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookSumaryDto {

    private long id;
    private String title;
    private LocalDate publicationDate;
    private String publisher;
    private String isbn;
    private String synopsis;
    private String cover;
    private Integer available;
}
