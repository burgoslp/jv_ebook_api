package com.leopoldo.ebook.ebook.services.interfaces;

import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.category.CategoryCreateDto;

public interface ICategoryServices {

    JsonApiResponse save(CategoryCreateDto categoryCreateDto);
    JsonApiResponse findAll();
    JsonApiResponse deleteById(Long id);
    JsonApiResponse countCategories();
}
