package com.leopoldo.ebook.ebook.services;


import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.category.CategoryCreateDto;
import com.leopoldo.ebook.ebook.dtos.category.CategorySumaryDto;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.models.Category;
import com.leopoldo.ebook.ebook.repositories.ICategoryRepository;
import com.leopoldo.ebook.ebook.services.interfaces.ICategoryServices;
import com.leopoldo.ebook.ebook.util.MapToDto;

@Service
public class CategoryServices implements ICategoryServices{

    @Autowired
    private ICategoryRepository cr;

    @Autowired
    private MapToDto map;

    @Override
    public JsonApiResponse save(CategoryCreateDto categoryCreateDto) {
        
        Category category= Category.builder()
                .name(categoryCreateDto.getName())
                .description(categoryCreateDto.getDescription())
                .build();



        return JsonApiResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message("Se ha creado la categoria correctamente")
                .data(map.mapToDto(cr.save(category), CategorySumaryDto.class))
                .build();
    }   

    @Override
    public JsonApiResponse findAll() {
        

        return JsonApiResponse.builder()
        .code(HttpStatus.OK.value())
        .message(HttpStatus.OK.getReasonPhrase())
        .data(map.mapToDto((List<Category>)cr.findAll(), CategorySumaryDto.class))
        .build();
    }

    @Override
    public JsonApiResponse delete(Long id) {
        
        cr.findById(id).ifPresentOrElse(category -> {
            cr.delete(category);
        }, () -> {
            throw new ApiException(ApiError.CATEGORY_BYID_NOT_FOUND);
        });

       
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Categoria eliminada correctamente")
                .build();
    }

}
