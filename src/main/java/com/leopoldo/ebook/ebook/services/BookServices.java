package com.leopoldo.ebook.ebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.leopoldo.ebook.ebook.dtos.Book.BookCreateDto;
import com.leopoldo.ebook.ebook.dtos.Book.BookDetailsDto;
import com.leopoldo.ebook.ebook.dtos.Book.BookSumaryDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.models.Book;
import com.leopoldo.ebook.ebook.repositories.IBookRepository;
import com.leopoldo.ebook.ebook.services.interfaces.IBookServices;
import com.leopoldo.ebook.ebook.util.MapToDto;

@Service
public class BookServices implements IBookServices {

    @Autowired
    private IBookRepository br;

    @Autowired
    private MapToDto map;

    @Override
    public JsonApiResponse save(BookCreateDto bookCreateDto) {

        Book book = Book.builder()
                .title(bookCreateDto.getTitle())
                .publicationDate(bookCreateDto.getPublicationDate())
                .publisher(bookCreateDto.getPublisher())
                .isbn(bookCreateDto.getIsbn())
                .synopsis(bookCreateDto.getSynopsis())
                .cover(bookCreateDto.getCover())
                .build();


       
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(book)
                .build();
    }

    @Override
    public JsonApiResponse findAll() {
       
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.mapToDto((List<Book>)br.findAll(), BookSumaryDto.class))
                .build();
    }

    @Override
    public JsonApiResponse findById(Long id) {
        Optional<Book> book = br.findById(id);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.mapToDto(book.orElseThrow(() -> new ApiException(ApiError.BOOK_BYID_NOT_FOUND)), BookDetailsDto.class))
                .build();
    }

}
