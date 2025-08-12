package com.leopoldo.ebook.ebook.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.leopoldo.ebook.ebook.models.Author;

@Repository
public interface IAuthorRepository  extends CrudRepository<Author,Long>{

    
} 
