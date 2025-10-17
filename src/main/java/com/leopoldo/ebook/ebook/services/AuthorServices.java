package com.leopoldo.ebook.ebook.services;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.leopoldo.ebook.ebook.dtos.Author.AuthorCreateDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.mappers.AuthorMapper;
import com.leopoldo.ebook.ebook.models.Author;
import com.leopoldo.ebook.ebook.models.Book;
import com.leopoldo.ebook.ebook.models.Nationality;
import com.leopoldo.ebook.ebook.repositories.IAuthorRepository;
import com.leopoldo.ebook.ebook.repositories.IBookRepository;
import com.leopoldo.ebook.ebook.repositories.INationalityRepository;
import com.leopoldo.ebook.ebook.services.interfaces.IAuthorServices;

@Service
public class AuthorServices implements IAuthorServices {

    @Autowired
    private IAuthorRepository ar;

    @Autowired
    private IBookRepository br;

    @Autowired
    private INationalityRepository nr;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public JsonApiResponse save(AuthorCreateDto authorCreateDto) {

        Nationality nationality= nr.findById(authorCreateDto.getNationalityId()).orElseThrow(() -> new ApiException(ApiError.NATIONALITY_BYID_NOT_FOUND));

        Author author = Author.builder()
                                .name(authorCreateDto.getName())
                                .lastname(authorCreateDto.getLastname())
                                .birthDate(LocalDate.parse(authorCreateDto.getBirthDate()).atStartOfDay())
                                .nationality(nationality)
                                .biography(authorCreateDto.getBiography())
                                .image(authorCreateDto.getImage())
                                .createdAt(LocalDateTime.now())
                                .build();

        
        return JsonApiResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message(HttpStatus.CREATED.getReasonPhrase())
                .data(authorMapper.authorToAuthorSumaryDto(ar.save(author)))
                .build();
    }

    @Override
    public JsonApiResponse findAll() {
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(authorMapper.authorsToAuthorSumaryDtos((List<Author>)ar.findAll()))
                .build();
    }

    @Override
    public JsonApiResponse findById(Long id) {

        Optional<Author> author= ar.findById(id);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(authorMapper.authorToAuthorDetailsDto(author.orElseThrow(()-> new ApiException(ApiError.AUTHOR_BYID_NOT_FOUND))))
                .build();
    }

    @Override
    public JsonApiResponse deleteById(Long id) {

        ar.findById(id).ifPresentOrElse(author ->{

            ar.delete(author);

        }, ()->{
            throw new ApiException(ApiError.AUTHOR_BYID_NOT_FOUND);
        });

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Autor eliminado correctamente")
                .build();
    }

    @Override
    public JsonApiResponse addBook(Long authorId, Long bookId) {
       
        Author author = ar.findById(authorId).orElseThrow(() -> new ApiException(ApiError.AUTHOR_BYID_NOT_FOUND));
        Book book= br.findById(bookId).orElseThrow(()-> new ApiException(ApiError.BOOK_BYID_NOT_FOUND));

        if (author.getBooks().contains(book)) {
            throw new ApiException(ApiError.BOOK_ALREADY_EXISTS);
        }

        author.getBooks().add(book);
        ar.save(author);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Libro agregado al autor correctamente")
                .build();
    }

    @Override
    public JsonApiResponse deleteBook(Long authorId, Long bookId) {
        
        Author author = ar.findById(authorId).orElseThrow(() -> new ApiException(ApiError.AUTHOR_BYID_NOT_FOUND));
        Book book= br.findById(bookId).orElseThrow(()-> new ApiException(ApiError.BOOK_BYID_NOT_FOUND));

        if (!author.getBooks().contains(book)) {
            throw new ApiException(ApiError.BOOK_NOT_FOUND_IN_AUTHOR);
        }


        author.getBooks().remove(book);
        ar.save(author);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Libro eliminado del autor correctamente")
                .build();
    }

    @Override
    public JsonApiResponse countAuthors() {
       
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(ar.count())
                .build();
    }

    

}
