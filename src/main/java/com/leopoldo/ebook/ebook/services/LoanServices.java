package com.leopoldo.ebook.ebook.services;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.Loan.LoanCreateDto;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.models.Book;
import com.leopoldo.ebook.ebook.models.Loan;
import com.leopoldo.ebook.ebook.models.User;
import com.leopoldo.ebook.ebook.repositories.IBookRepository;
import com.leopoldo.ebook.ebook.repositories.ILoanRepository;
import com.leopoldo.ebook.ebook.repositories.IUserRepository;
import com.leopoldo.ebook.ebook.services.interfaces.ILoanServices;
import com.leopoldo.ebook.ebook.services.interfaces.ISendEmailServices;

@Service
public class LoanServices implements ILoanServices {

    @Autowired
    private IUserRepository ur;

    @Autowired
    private IBookRepository br;

    @Autowired
    private ILoanRepository lr;

    @Autowired
    private ISendEmailServices es;

    @Override
    public JsonApiResponse loanRequest(LoanCreateDto loanCreateDto) {

        Book book = br.findById(loanCreateDto.getBookId()).orElseThrow(() -> new ApiException(ApiError.BOOK_BYID_NOT_FOUND));
        User user = ur.findById(loanCreateDto.getUserId()).orElseThrow(() -> new ApiException(ApiError.USER_BYID_NOT_FOUND));

        
        if(book.getAvailable() == null || book.getAvailable() <= 0){
            throw new ApiException(ApiError.BOOK_NOT_AVAILABLE);
        }

        Loan loan= Loan.builder()
                .book(book)
                .user(user)
                .requestDate(LocalDateTime.now())
                .loanDate(null)
                .returnDate(null)
                .build();

        lr.save(loan);

        es.sendEmail(user.getEmail(), "Solicitud de Prestamo", "Su solicitud de prestamo del libro "+book.getTitle()+" ha sido recibida y está en proceso de revisión. Le notificaremos una vez que se haya tomado una decisión sobre su solicitud.");

        return JsonApiResponse.builder()
                .message(HttpStatus.CREATED.getReasonPhrase())
                .code(HttpStatus.CREATED.value())
                .data("Prestamo Solicitado con exito")
                .build();
    }

    

}
