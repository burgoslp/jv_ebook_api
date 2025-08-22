package com.leopoldo.ebook.ebook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.category.CategoryCreateDto;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.mappers.CategoryMapper;
import com.leopoldo.ebook.ebook.models.Category;
import com.leopoldo.ebook.ebook.repositories.ICategoryRepository;
import com.leopoldo.ebook.ebook.services.interfaces.ICategoryServices;

@Service
public class CategoryServices implements ICategoryServices{

    @Autowired
    private ICategoryRepository cr;

    @Autowired
    private CategoryMapper map;

    @Override
    public JsonApiResponse save(CategoryCreateDto categoryCreateDto) {
        
        Category category= Category.builder()
                .name(categoryCreateDto.getName())
                .description(categoryCreateDto.getDescription())
                .build();



        return JsonApiResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message("Se ha creado la categoria correctamente")
                .data(map.categoryToCategorySumaryDto(cr.save(category)))
                .build();
    }   

    @Override
    public JsonApiResponse findAll() {
        

        return JsonApiResponse.builder()
        .code(HttpStatus.OK.value())
        .message(HttpStatus.OK.getReasonPhrase())
        .data(map.categoryToCategorySumaryDto((List<Category>)cr.findAll()))
        .build();
    }

    @Override
    public JsonApiResponse deleteById(Long id) {
        
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
