package com.leopoldo.ebook.ebook.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leopoldo.ebook.ebook.dtos.Book.BookCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.services.BookServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookServices bs;


    @PostMapping()
    public ResponseEntity<JsonApiResponse> save(@Valid @RequestBody BookCreateDto bookCreateDto) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(bs.save(bookCreateDto));
    }
    
}
