package com.leopoldo.ebook.ebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.leopoldo.ebook.ebook.dtos.Comment.CommentCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.services.interfaces.ICommentServices;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    private ICommentServices cos;

    @PostMapping()
    public ResponseEntity<JsonApiResponse> save(@Valid @RequestBody CommentCreateDto commentCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(cos.save(commentCreateDto));
    }
    

}
