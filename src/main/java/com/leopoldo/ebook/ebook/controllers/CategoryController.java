package com.leopoldo.ebook.ebook.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.category.CategoryCreateDto;
import com.leopoldo.ebook.ebook.services.CategoryServices;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryServices cs;


   @PostMapping()
   public ResponseEntity<JsonApiResponse> save(@Valid @RequestBody CategoryCreateDto categoryCreateDto){

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(cs.save(categoryCreateDto));
   }

   @GetMapping()
   public ResponseEntity<JsonApiResponse> findAll(){

        return ResponseEntity.ok().body(cs.findAll());
   }
    
   @DeleteMapping("/{id}")
   public ResponseEntity<JsonApiResponse> delete(@PathVariable Long id){

        return ResponseEntity.ok().body(cs.delete(id));
   }
}
