package com.leopoldo.ebook.ebook.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.User.UserCreateDto;
import com.leopoldo.ebook.ebook.dtos.User.UserDetailsDto;
import com.leopoldo.ebook.ebook.dtos.User.UserSumaryDto;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.models.Role;
import com.leopoldo.ebook.ebook.models.User;
import com.leopoldo.ebook.ebook.repositories.IRoleRepository;
import com.leopoldo.ebook.ebook.repositories.IUserRepository;
import com.leopoldo.ebook.ebook.services.interfaces.IUserServices;
import com.leopoldo.ebook.ebook.util.MapToDto;

@Service
public class UserServices implements IUserServices {

    @Autowired
    private IUserRepository ur;

    @Autowired
    private IRoleRepository rr;

    @Autowired
    private EmailServices emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MapToDto map;

    @Override
    public JsonApiResponse save(UserCreateDto userCreateDto) {

        Optional<Role> rol = rr.findByName("ROLE_USER");
        List<Role> rolesList = new ArrayList<>();
         
        rol.ifPresentOrElse(r ->{
            rolesList.add(r);
        },()->{
                throw new ApiException(ApiError.ROLE_BYNAME_NOT_FOUND);
        });

        if(userCreateDto.isAdmin){
            Optional<Role> rolAdmin = rr.findByName("ROLE_ADMIN");
            rolAdmin.ifPresentOrElse(r ->{
                rolesList.add(r);
            }, () -> {
                throw new ApiException(ApiError.ROLE_BYNAME_NOT_FOUND);
            });
        }

        User user = User.builder()
                .username(userCreateDto.getUsername())
                .password(passwordEncoder.encode(userCreateDto.getPassword()))
                .email(userCreateDto.getEmail())
                .isAdmin(userCreateDto.isAdmin)
                .roles(rolesList)
                .build();

        // registro del usuario y conversion a DTO
        UserDetailsDto usuarioDetailsDto = (UserDetailsDto) map.mapToDto(ur.save(user), UserDetailsDto.class);

        // Enviar correo de confirmación
        emailService.sendEmail(usuarioDetailsDto.getEmail(), "Registro exitoso EBOOK", "Hola "+ usuarioDetailsDto.getUsername() +", tu registro fue exitoso.");

        return JsonApiResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message("Usuario creado correctamente")
                .data(usuarioDetailsDto)
                .build();
    }

    @Override
    public JsonApiResponse findAll() {

        return JsonApiResponse
                            .builder()
                            .code(HttpStatus.OK.value())
                            .message("Lista de usuarios")
                            .data(map.mapToDto((List<User>)ur.findAll(), UserSumaryDto.class)).build();
    }

    @Override
    public JsonApiResponse findById(Long id) {
        
        Optional<User> user = ur.findById(id);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("Usuario encontrado")
                .data(
                    map.mapToDto(user.orElseThrow(() -> new ApiException(ApiError.USER_BYID_NOT_FOUND)), UserSumaryDto.class)
                )
                .build();
    }

    

}
