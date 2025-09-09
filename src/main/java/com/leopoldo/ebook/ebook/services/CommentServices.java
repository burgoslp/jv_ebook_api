package com.leopoldo.ebook.ebook.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.leopoldo.ebook.ebook.dtos.Comment.CommentCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.models.Book;
import com.leopoldo.ebook.ebook.models.Comment;
import com.leopoldo.ebook.ebook.models.User;
import com.leopoldo.ebook.ebook.repositories.IBookRepository;
import com.leopoldo.ebook.ebook.repositories.ICommentRepository;
import com.leopoldo.ebook.ebook.repositories.IUserRepository;
import com.leopoldo.ebook.ebook.services.interfaces.ICommentServices;

@Service
public class CommentServices implements ICommentServices{

    @Autowired
    private ICommentRepository cor;

    @Autowired
    private IBookRepository br;

    @Autowired
    private IUserRepository ur;

    @Override
    public JsonApiResponse save(CommentCreateDto commentCreateDto) {
       
        Book book =  br.findById(commentCreateDto.getBookId()).orElseThrow(()-> new ApiException(ApiError.BOOK_BYID_NOT_FOUND));
        User user = ur.findById(commentCreateDto.getUserId()).orElseThrow(()-> new ApiException(ApiError.USER_BYID_NOT_FOUND));

        Comment comment= Comment.builder()
                .description(commentCreateDto.getDescription())
                .book(book)
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();
        cor.save(comment);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Comentario guardado con exito")
                .build();
    }
}
