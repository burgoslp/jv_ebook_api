package com.leopoldo.ebook.ebook.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leopoldo.ebook.ebook.dtos.Author.AuthorCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.services.AuthorServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorServices as;

    @PostMapping()
    public ResponseEntity<JsonApiResponse> save(@Valid @RequestBody AuthorCreateDto authorCreateDto) {
        return ResponseEntity.ok().body(as.save(authorCreateDto));
    }
    
    @GetMapping()
    public ResponseEntity<JsonApiResponse> findAll() {
        return ResponseEntity.ok().body(as.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonApiResponse> getMethodName(@PathVariable Long id) {
        return ResponseEntity.ok().body(as.findById(id));
    }
    

}
