package com.leopoldo.ebook.ebook.services;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.leopoldo.ebook.ebook.dtos.Author.AuthorCreateDto;
import com.leopoldo.ebook.ebook.dtos.Author.AuthorDetailsDto;
import com.leopoldo.ebook.ebook.dtos.Author.AuthorSumaryDto;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.models.Author;
import com.leopoldo.ebook.ebook.repositories.IAuthorRepository;
import com.leopoldo.ebook.ebook.services.interfaces.IAuthorServices;
import com.leopoldo.ebook.ebook.util.MapToDto;

@Service
public class AuthorServices implements IAuthorServices {

    @Autowired
    private IAuthorRepository ar;

    @Autowired
    private MapToDto map;

    @Override
    public JsonApiResponse save(AuthorCreateDto authorCreateDto) {


        Author author = Author.builder()
                                .name(authorCreateDto.getName())
                                .lastname(authorCreateDto.getLastname())
                                .birthDate(LocalDate.parse(authorCreateDto.getBirthDate()))
                                .nationality(authorCreateDto.getNationality())
                                .biography(authorCreateDto.getBiography())
                                .image(authorCreateDto.getImage())
                                .createdAt(LocalDateTime.now())
                                .build();

        
        return JsonApiResponse.builder()
                .code(200)
                .message("Author creado correctamente")
                .data(map.mapToDto(ar.save(author),AuthorSumaryDto.class))
                .build();
    }

    @Override
    public JsonApiResponse findAll() {
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.mapToDto((List<Author>)ar.findAll(), AuthorSumaryDto.class))
                .build();
    }

    @Override
    public JsonApiResponse findById(Long id) {

        Optional<Author> author= ar.findById(id);

        
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.mapToDto(author.orElseThrow(()-> new ApiException(ApiError.AUTHOR_BYID_NOT_FOUND)), AuthorDetailsDto.class))
                .build();
    }

}
