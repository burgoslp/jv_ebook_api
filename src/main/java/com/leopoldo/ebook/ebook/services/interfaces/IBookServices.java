package com.leopoldo.ebook.ebook.services.interfaces;

import com.leopoldo.ebook.ebook.dtos.Book.BookCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;

public interface IBookServices {

    JsonApiResponse save(BookCreateDto bookCreateDto);
    JsonApiResponse findAll();
    JsonApiResponse findById(Long id);
    JsonApiResponse deleteById(Long id);
    JsonApiResponse usersWhoLiked(Long bookId);
    JsonApiResponse countLikes(Long bookId);
    JsonApiResponse addCategory(Long bookId,Long idCategory);
    JsonApiResponse removeCategory(Long bookId,Long idCategory);
    JsonApiResponse countBooks();
    JsonApiResponse countByCategory();
}
