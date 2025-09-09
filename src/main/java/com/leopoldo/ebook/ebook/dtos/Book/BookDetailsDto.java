package com.leopoldo.ebook.ebook.dtos.Book;

import java.time.LocalDate;
import java.util.List;

import com.leopoldo.ebook.ebook.dtos.Author.AuthorSumaryDto;
import com.leopoldo.ebook.ebook.dtos.Comment.CommentUserDetailsDto;
import com.leopoldo.ebook.ebook.dtos.category.CategorySumaryDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDetailsDto {

    private long id;
    private String title;
    private LocalDate publicationDate;
    private String publisher;
    private String isbn;
    private String synopsis;
    private String cover;
    private Integer available;
    private List<CommentUserDetailsDto> comments;
    private List<AuthorSumaryDto> authors;
    private List<CategorySumaryDto> categories;

}
