package com.leopoldo.ebook.ebook.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.User.UserCreateDto;
import com.leopoldo.ebook.ebook.services.interfaces.IUserServices;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private IUserServices us;

    @PostMapping()
    public ResponseEntity<JsonApiResponse> save(@Valid @RequestBody UserCreateDto user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(us.save(user));
    }

    @GetMapping()
    public ResponseEntity<JsonApiResponse> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(us.findAll());
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<JsonApiResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(us.findById(id));

    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<JsonApiResponse> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(us.delete(id));
    }

    @PostMapping("/{userId}/likes/{bookId}")
    public ResponseEntity<JsonApiResponse> addLike(@PathVariable Long userId, @PathVariable Long bookId) {
        
        return ResponseEntity.ok().body(us.addLike(userId, bookId));
    }
    
    @DeleteMapping("/{userId}/likes/{bookId}")
    public ResponseEntity<JsonApiResponse> removeLike(@PathVariable Long userId, @PathVariable Long bookId) {
        return ResponseEntity.ok().body(us.removeLike(userId, bookId));
    }

    @PostMapping("/{userId}/library/{bookId}")
    public ResponseEntity<JsonApiResponse> addLibrary(@PathVariable Long userId, @PathVariable Long bookId) {
        
        return ResponseEntity.ok().body(us.addLibrary(userId, bookId));
    }

    @DeleteMapping("/{userId}/library/{bookId}")
    public ResponseEntity<JsonApiResponse> removeLibrary(@PathVariable Long userId, @PathVariable Long bookId) {
        return ResponseEntity.ok().body(us.removeLibrary(userId, bookId));
    }

    @GetMapping("/{userId}/library")
    public ResponseEntity<JsonApiResponse> getMethodName(@PathVariable Long userId) {
        return ResponseEntity.ok().body(us.getUserLibrary(userId));
    }
    
}
