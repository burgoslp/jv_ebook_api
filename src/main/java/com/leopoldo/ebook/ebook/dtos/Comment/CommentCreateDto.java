package com.leopoldo.ebook.ebook.dtos.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentCreateDto {

    private String description;
    private Long userId;
    private Long bookId;
}
