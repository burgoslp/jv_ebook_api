package com.leopoldo.ebook.ebook.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.leopoldo.ebook.ebook.dtos.status.StatusSumaryDto;
import com.leopoldo.ebook.ebook.models.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusSumaryDto statusToSumaryDto(Status status);
    List<StatusSumaryDto> statusToSumaryDto(List<Status> status);
}
