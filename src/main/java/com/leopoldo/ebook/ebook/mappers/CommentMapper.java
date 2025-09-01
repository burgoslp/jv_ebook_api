package com.leopoldo.ebook.ebook.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.leopoldo.ebook.ebook.dtos.Comment.CommentBookDetailsDto;
import com.leopoldo.ebook.ebook.dtos.Comment.CommentSumaryDto;
import com.leopoldo.ebook.ebook.dtos.Comment.CommentUserDetailsDto;
import com.leopoldo.ebook.ebook.models.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentBookDetailsDto commentToCommentBookDetailDto(Comment comment);
    CommentUserDetailsDto commentToCommentUserDetailDto(Comment comment);
    CommentSumaryDto commentToCommentSummaryDto(Comment comment);
    List<CommentSumaryDto> commentToCommentSummaryDto(List<Comment> comment);
}
