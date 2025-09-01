package com.leopoldo.ebook.ebook.dtos.Comment;

import com.leopoldo.ebook.ebook.dtos.Book.BookSumaryDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentBookDetailsDto {
    private Long id;
    private String description;
    private BookSumaryDto book;
}
