package com.leopoldo.ebook.ebook.services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.User.UserCreateDto;
import com.leopoldo.ebook.ebook.dtos.User.UserSumaryDto;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.mappers.UserMapper;
import com.leopoldo.ebook.ebook.models.Book;
import com.leopoldo.ebook.ebook.models.Role;
import com.leopoldo.ebook.ebook.models.User;
import com.leopoldo.ebook.ebook.repositories.IBookRepository;
import com.leopoldo.ebook.ebook.repositories.IRoleRepository;
import com.leopoldo.ebook.ebook.repositories.IUserRepository;
import com.leopoldo.ebook.ebook.services.interfaces.IUserServices;

@Service
public class UserServices implements IUserServices {

    @Autowired
    private IUserRepository ur;

    @Autowired
    private IBookRepository br;

    @Autowired
    private IRoleRepository rr;

    @Autowired
    private EmailServices emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper map;


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
                .createdAt(LocalDateTime.now())
                .roles(rolesList)
                .build();

        // registro del usuario y conversion a DTO
        UserSumaryDto usuarioDetailsDto =  map.userToUserSumaryDto(ur.save(user));

        // Enviar correo de confirmación
        emailService.sendEmail(usuarioDetailsDto.getEmail(), "Registro exitoso EBOOK", "Hola "+ usuarioDetailsDto.getUsername() +", tu registro fue exitoso.");

        return JsonApiResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message(HttpStatus.CREATED.getReasonPhrase())
                .data(usuarioDetailsDto)
                .build();
    }

    @Override
    public JsonApiResponse findAll() {

        return JsonApiResponse
                            .builder()
                            .code(HttpStatus.OK.value())
                            .message("Lista de usuarios")
                            .data(map.userToUserSumaryDto((List<User>)ur.findAll()))
                            .build();
    }

    @Override
    public JsonApiResponse findById(Long id) {
        
        Optional<User> user = ur.findById(id);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message("Usuario encontrado")
                .data(
                   map.userToUserDetailsDto(user.orElseThrow(() -> new ApiException(ApiError.USER_BYID_NOT_FOUND)))
                )
                .build();
    }

    @Override
    public JsonApiResponse delete(Long id) {
        
        Optional<User> OptionalUser= ur.findById(id);

        OptionalUser.ifPresentOrElse(user ->{

           ur.delete(user);

        }, ()->{
            throw new ApiException(ApiError.USER_BYID_NOT_FOUND);
        });

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Usuario eliminado")
                .build();

    }

    public JsonApiResponse addLike(Long userId, Long bookId){
        
        User user = ur.findById(userId).orElseThrow(()-> new ApiException(ApiError.USER_BYID_NOT_FOUND));
        Book book = br.findById(bookId).orElseThrow(()-> new ApiException(ApiError.BOOK_BYID_NOT_FOUND));

        if(user.getLikes().contains(book)){
            throw new ApiException(ApiError.BOOK_ALREADY_LIKED);
        }

        user.getLikes().add(book);
        ur.save(user);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("like agregado correctamente")
                .build();
    }

    
    @Override
    public JsonApiResponse removeLike(Long userId, Long bookId) {

        User user = ur.findById(userId).orElseThrow(()-> new ApiException(ApiError.USER_BYID_NOT_FOUND));
        Book book = br.findById(bookId).orElseThrow(()-> new ApiException(ApiError.BOOK_BYID_NOT_FOUND));

        if(!user.getLikes().contains(book)){
            throw new ApiException(ApiError.BOOK_NOT_LIKED);
        }

        user.getLikes().remove(book);
        ur.save(user);
       
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("like eliminado correctamente")
                .build();
    }

    @Override
    public JsonApiResponse addLibrary(Long userId, Long bookId) {
        User user = ur.findById(userId).orElseThrow(()-> new ApiException(ApiError.USER_BYID_NOT_FOUND));
        Book book = br.findById(bookId).orElseThrow(()-> new ApiException(ApiError.BOOK_BYID_NOT_FOUND));

        if(user.getLibraries().contains(book)){
            throw new ApiException(ApiError.BOOK_ALREADY_IN_LIBRARY);
        }

        user.getLibraries().add(book);
        ur.save(user);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Libro agregado a la librería correctamente")
                .build();
    }

    @Override
    public JsonApiResponse removeLibrary(Long userId, Long bookId) {
        User user = ur.findById(userId).orElseThrow(()-> new ApiException(ApiError.USER_BYID_NOT_FOUND));
        Book book = br.findById(bookId).orElseThrow(()-> new ApiException(ApiError.BOOK_BYID_NOT_FOUND));

        if(!user.getLibraries().contains(book)){
            throw new ApiException(ApiError.BOOK_NOT_IN_LIBRARY);

        }

        user.getLibraries().remove(book);
        ur.save(user);

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data("Libro eliminado de la librería correctamente")
                .build();
    }

    @Override
    public JsonApiResponse getUserLibrary(Long userId) {
    
        User user = ur.findById(userId).orElseThrow(()-> new ApiException(ApiError.USER_BYID_NOT_FOUND));

       
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.userToUserLibraryDto(user))
                .build();
    }

}
