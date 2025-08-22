package com.leopoldo.ebook.ebook.dtos.User;
import java.util.List;
import com.leopoldo.ebook.ebook.dtos.RoleDto.RoleDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailsDto {

    @NotBlank
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    private List<RoleDto> roles;


}
