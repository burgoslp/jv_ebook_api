package com.leopoldo.ebook.ebook.dtos.Comment;

import com.leopoldo.ebook.ebook.dtos.User.UserSumaryDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentUserDetailsDto {
    private Long id;
    private String description;
    private UserSumaryDto user;
}
