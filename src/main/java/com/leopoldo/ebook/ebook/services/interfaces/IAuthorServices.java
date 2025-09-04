package com.leopoldo.ebook.ebook.services.interfaces;

import com.leopoldo.ebook.ebook.dtos.Author.AuthorCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;

public interface IAuthorServices {
    JsonApiResponse save(AuthorCreateDto authorCreateDto); 
    JsonApiResponse findAll();
    JsonApiResponse findById(Long id);
    JsonApiResponse deleteById(Long id);
    JsonApiResponse addBook(Long authorId, Long bookId);
    JsonApiResponse deleteBook(Long authorId, Long bookId);
    JsonApiResponse countAuthors();
}
