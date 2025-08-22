package com.leopoldo.ebook.ebook.mappers;
import java.util.List;

import org.mapstruct.Mapper;
import com.leopoldo.ebook.ebook.dtos.Author.AuthorDetailsDto;
import com.leopoldo.ebook.ebook.dtos.Author.AuthorSumaryDto;
import com.leopoldo.ebook.ebook.models.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDetailsDto authorToAuthorDetailsDto(Author author);
    AuthorSumaryDto authorToAuthorSumaryDto(Author author);
    List<AuthorSumaryDto> authorsToAuthorSumaryDtos(List<Author> authors);
}
