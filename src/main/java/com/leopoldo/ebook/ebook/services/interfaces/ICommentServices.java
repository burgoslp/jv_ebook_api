package com.leopoldo.ebook.ebook.services.interfaces;

import com.leopoldo.ebook.ebook.dtos.Comment.CommentCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;

public interface ICommentServices {
    JsonApiResponse save(CommentCreateDto commentCreateDto);
}
