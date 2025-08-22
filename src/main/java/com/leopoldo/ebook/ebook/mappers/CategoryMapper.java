package com.leopoldo.ebook.ebook.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.leopoldo.ebook.ebook.dtos.category.CategorySumaryDto;
import com.leopoldo.ebook.ebook.models.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategorySumaryDto categoryToCategorySumaryDto(Category category);
    List<CategorySumaryDto> categoryToCategorySumaryDto(List<Category> categories);
}
