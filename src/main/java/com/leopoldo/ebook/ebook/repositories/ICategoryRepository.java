package com.leopoldo.ebook.ebook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leopoldo.ebook.ebook.models.Book;
import com.leopoldo.ebook.ebook.models.Category;

@Repository
public interface ICategoryRepository extends CrudRepository<Category, Long> {
    
    boolean existsByName(String name);

    
}
