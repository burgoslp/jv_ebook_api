package com.leopoldo.ebook.ebook.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.leopoldo.ebook.ebook.models.Book;

@Repository
public interface IBookRepository extends CrudRepository<Book, Long>{

    List<Book> findAllByCategories_Id(Long id);

}
