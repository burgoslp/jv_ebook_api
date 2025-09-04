package com.leopoldo.ebook.ebook.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leopoldo.ebook.ebook.dtos.Book.BookCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.services.BookServices;
import com.leopoldo.ebook.ebook.services.interfaces.IBookServices;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private IBookServices bs;


    @PostMapping()
    public ResponseEntity<JsonApiResponse> save(@Valid @RequestBody BookCreateDto bookCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bs.save(bookCreateDto));
    }

    @GetMapping()
    public ResponseEntity<JsonApiResponse> findAll(){
        return ResponseEntity.ok().body(bs.findAll());
    }    

    @GetMapping("/{id}")
    public ResponseEntity<JsonApiResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(bs.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JsonApiResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(bs.deleteById(id));

    }
    
    @GetMapping("/{bookId}/usersWhoLiked")
    public ResponseEntity<JsonApiResponse> usersWhoLiked(@PathVariable Long bookId) {
        return ResponseEntity.ok().body(bs.usersWhoLiked(bookId));
    }

    @GetMapping("/{bookId}/likes")
    public ResponseEntity<JsonApiResponse> countLikes(@PathVariable Long bookId) {
        return ResponseEntity.ok().body(bs.countLikes(bookId));
    }
    

    @PostMapping("/{bookId}/categories/{idCategory}")
    public ResponseEntity<JsonApiResponse> addCategory(@PathVariable Long bookId,@PathVariable Long idCategory) {
        return ResponseEntity.ok().body(bs.addCategory(bookId,idCategory));
    }

    @DeleteMapping("/{bookId}/categories/{idCategory}")
    public ResponseEntity<JsonApiResponse> removeCategory(@PathVariable Long bookId,@PathVariable Long idCategory) {
        return ResponseEntity.ok().body(bs.removeCategory(bookId,idCategory));
    }
}
