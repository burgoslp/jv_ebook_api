package com.leopoldo.ebook.ebook.dtos.Book;

import java.time.LocalDate;
import java.util.List;

import com.leopoldo.ebook.ebook.models.Author;
import com.leopoldo.ebook.ebook.models.Category;
import com.leopoldo.ebook.ebook.models.Comment;

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
    private List<Comment> comments;
    private List<Author> authors;
    private List<Category> categories;

}
