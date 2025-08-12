package com.leopoldo.ebook.ebook.services.interfaces;

import java.util.List;

import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.User.UserCreateDto;
import com.leopoldo.ebook.ebook.models.User;

public interface IUserServices {
    JsonApiResponse save(UserCreateDto user);
    JsonApiResponse findAll();
    JsonApiResponse findById(Long id);
}
