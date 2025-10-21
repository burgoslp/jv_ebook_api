package com.leopoldo.ebook.ebook.dtos.status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StatusSumaryDto {

    private Long id;
    private String name;
    private String description;
}
