package com.leopoldo.ebook.ebook.dtos.User;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSumaryDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
