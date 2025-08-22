package com.leopoldo.ebook.ebook.services.interfaces;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.User.UserCreateDto;

public interface IUserServices {
    JsonApiResponse save(UserCreateDto user);
    JsonApiResponse findAll();
    JsonApiResponse findById(Long id);
    JsonApiResponse delete(Long id);
    JsonApiResponse addLike(Long userId, Long bookId);
    JsonApiResponse removeLike(Long userId, Long bookId);
}
