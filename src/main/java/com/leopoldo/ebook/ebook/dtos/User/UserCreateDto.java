package com.leopoldo.ebook.ebook.dtos.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import validations.UniqueUserUsername;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserCreateDto {
    @NotBlank
    @UniqueUserUsername
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    // campo opcional
    public boolean isAdmin;
}
