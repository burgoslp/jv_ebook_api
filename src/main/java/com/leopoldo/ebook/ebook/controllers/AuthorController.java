package com.leopoldo.ebook.ebook.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leopoldo.ebook.ebook.dtos.Author.AuthorCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.services.interfaces.IAuthorServices;
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
@RequestMapping("api/v1/authors")
public class AuthorController {

    @Autowired
    private IAuthorServices as;

    @PostMapping()
    public ResponseEntity<JsonApiResponse> save(@Valid @RequestBody AuthorCreateDto authorCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(as.save(authorCreateDto));
    }
    
    @GetMapping()
    public ResponseEntity<JsonApiResponse> findAll() {
        return ResponseEntity.ok().body(as.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonApiResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(as.findById(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<JsonApiResponse> deleteById(@PathVariable Long id){
        return ResponseEntity.ok().body(as.deleteById(id));
    }

    @PostMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<JsonApiResponse> addBook(@PathVariable Long authorId, @PathVariable Long bookId) {
        return ResponseEntity.ok().body(as.addBook(authorId, bookId));
    }

    @DeleteMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<JsonApiResponse> deleteBook(@PathVariable Long authorId, @PathVariable Long bookId) {
        return ResponseEntity.ok().body(as.deleteBook(authorId, bookId));
    }
    
    @GetMapping("/count")
    public ResponseEntity<JsonApiResponse> count() {
        return ResponseEntity.ok().body(as.countAuthors());
    }
    
}
