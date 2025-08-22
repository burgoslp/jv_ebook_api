package com.leopoldo.ebook.ebook.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.leopoldo.ebook.ebook.dtos.Book.BookDetailsDto;
import com.leopoldo.ebook.ebook.dtos.Book.BookSumaryDto;
import com.leopoldo.ebook.ebook.models.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDetailsDto bookToBookDetailsDto(Book book);
    BookSumaryDto bookToBookSumaryDto(Book book);
    List<BookSumaryDto> bookToBookSumaryDto(List<Book> books);
}
