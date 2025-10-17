package com.leopoldo.ebook.ebook.dtos.Nationality;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NationalityDetailsDto {

    private Long id;
    private String name;
    private String demonym;
    private String isoCode;
}
