package com.leopoldo.ebook.ebook.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.leopoldo.ebook.ebook.dtos.Nationality.NationalityDetailsDto;
import com.leopoldo.ebook.ebook.models.Nationality;

@Mapper(componentModel = "spring")
public interface NationalityMapper {
    List<NationalityDetailsDto> nationalityToNationalityDetailsDtos(List<Nationality> nationalities);
}
