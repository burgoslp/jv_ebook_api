package com.leopoldo.ebook.ebook.services;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.leopoldo.ebook.ebook.dtos.Book.BookCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.mappers.BookMapper;
import com.leopoldo.ebook.ebook.mappers.UserMapper;
import com.leopoldo.ebook.ebook.models.Book;
import com.leopoldo.ebook.ebook.models.Category;
import com.leopoldo.ebook.ebook.repositories.IBookRepository;
import com.leopoldo.ebook.ebook.repositories.ICategoryRepository;
import com.leopoldo.ebook.ebook.services.interfaces.IBookServices;

@Service
public class BookServices implements IBookServices {

    @Autowired
    private IBookRepository br;

    @Autowired
    private ICategoryRepository cr;

    @Autowired
    private BookMapper map;

    @Autowired
    private UserMapper userMap;

    @Override
    public JsonApiResponse save(BookCreateDto bookCreateDto) {

        Book book = Book.builder()
                .title(bookCreateDto.getTitle())
                .publicationDate(LocalDate.parse(bookCreateDto.getPublicationDate()))
                .publisher(bookCreateDto.getPublisher())
                .isbn(bookCreateDto.getIsbn())
                .synopsis(bookCreateDto.getSynopsis())
                .cover(bookCreateDto.getCover())
                .build();


       
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.bookToBookSumaryDto(br.save(book)))
                .build();
    }

    @Override
    public JsonApiResponse findAll() {
       
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.bookToBookSumaryDto((List<Book>)br.findAll()))
                .build();
    }

    @Override
    public JsonApiResponse findById(Long id) {
        Optional<Book> book = br.findById(id);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.bookToBookDetailsDto(book.orElseThrow(() -> new ApiException(ApiError.BOOK_BYID_NOT_FOUND))))
                .build();
    }

    @Override
    public JsonApiResponse deleteById(Long id) {

        br.findById(id).ifPresentOrElse(book -> {
            br.delete(book);
        }, () -> {
            throw new ApiException(ApiError.BOOK_BYID_NOT_FOUND);
        });
        
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Libro eliminado correctamente")
                .build();
    }

    @Override
    public JsonApiResponse usersWhoLiked(Long bookId) {

        Book book= br.findById(bookId).orElseThrow( () -> new ApiException(ApiError.BOOK_BYID_NOT_FOUND) );

        
        
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(userMap.userToUserSumaryDto(book.getUsersWhoLiked()))
                .build();
    }

    @Override
    public JsonApiResponse countLikes(Long bookId) {
        
        Book book= br.findById(bookId).orElseThrow( () -> new ApiException(ApiError.BOOK_BYID_NOT_FOUND) );


       return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(book.getUsersWhoLiked().size())
                .build();
    }

    @Override
    public JsonApiResponse addCategory(Long bookId, Long idCategory) {

        Book book= br.findById(bookId).orElseThrow( () -> new ApiException(ApiError.BOOK_BYID_NOT_FOUND) );
        Category category= cr.findById(idCategory).orElseThrow( () -> new ApiException(ApiError.CATEGORY_BYID_NOT_FOUND));

        if(book.getCategories().contains(category)){
            throw new ApiException(ApiError.CATEGORY_ALREADY_EXISTS);

        }


        category.getBooks().add(book);
        cr.save(category);

      
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Categoría añadida correctamente")
                .build();
    }

   

    @Override
    public JsonApiResponse removeCategory(Long bookId, Long idCategory) {
        
        Book book= br.findById(bookId).orElseThrow( () -> new ApiException(ApiError.BOOK_BYID_NOT_FOUND) );
        Category category= cr.findById(idCategory).orElseThrow( () -> new ApiException(ApiError.CATEGORY_BYID_NOT_FOUND));

        category.getBooks().remove(book);
        cr.save(category);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Categoría eliminada correctamente")
                .build();
    }

    

    

}
