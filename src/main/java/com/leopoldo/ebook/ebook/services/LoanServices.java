package com.leopoldo.ebook.ebook.services;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.Loan.LoanRequestCreateDto;
import com.leopoldo.ebook.ebook.exeptions.ApiError;
import com.leopoldo.ebook.ebook.exeptions.ApiException;
import com.leopoldo.ebook.ebook.mappers.LoanMapper;
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

    @Autowired
    private LoanMapper map;

    @Override
    public JsonApiResponse request(LoanRequestCreateDto loanCreateDto) {

        Book book = br.findById(loanCreateDto.getBookId()).orElseThrow(() -> new ApiException(ApiError.BOOK_BYID_NOT_FOUND));
        User user = ur.findById(loanCreateDto.getUserId()).orElseThrow(() -> new ApiException(ApiError.USER_BYID_NOT_FOUND));

        
        if(book.getAvailable() == null || book.getAvailable() <= 0){
            throw new ApiException(ApiError.BOOK_NOT_AVAILABLE);
        }

        Loan loan= Loan.builder()
                .book(book)
                .user(user)
                .requestDate(LocalDateTime.now())
                .status("pending")
                .build();

        lr.save(loan);

        es.sendEmail(user.getEmail(), "Solicitud de Prestamo", "Su solicitud de prestamo del libro "+book.getTitle()+" ha sido recibida y está en proceso de revisión. Le notificaremos una vez que se haya tomado una decisión sobre su solicitud.");

        return JsonApiResponse.builder()
                .message(HttpStatus.CREATED.getReasonPhrase())
                .code(HttpStatus.CREATED.value())
                .data("Prestamo Solicitado con exito")
                .build();
    }

    public JsonApiResponse approve(Long loanId) {
       
        Loan loan = lr.findById(loanId).orElseThrow(() -> new ApiException(ApiError.LOAN_BYID_NOT_FOUND));
        Book book = loan.getBook();


        if(!loan.getStatus().equals("pending")){
            throw new ApiException(ApiError.LOAN_VALIDATION_ERROR);
        }

        if(book.getAvailable() == null || book.getAvailable() <= 0){
            throw new ApiException(ApiError.BOOK_NOT_AVAILABLE);
        }
        
        loan.setStatus("aproved");
        loan.setLoanDate(LocalDateTime.now());
        loan.setReturnDate(LocalDateTime.now().plusDays(7));
        lr.save(loan);

        book.setAvailable(book.getAvailable() - 1);
        br.save(book);

        es.sendEmail(loan.getUser().getEmail(), "Aprobación de Préstamo", "Su solicitud de préstamo del libro "+book.getTitle()+" ha sido aprobada. Por favor, recuerde que la fecha de devolución es el "+loan.getReturnDate().toLocalDate()+". ¡Disfrute de su lectura!");

        return JsonApiResponse.builder()
                .message(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK.value())
                .data("Prestamo Aprobado con exito")
                .build();
    }

    @Override
    public JsonApiResponse reject(Long loanId) {
       
        Loan loan = lr.findById(loanId).orElseThrow(() -> new ApiException(ApiError.LOAN_BYID_NOT_FOUND));

        if(!loan.getStatus().equals("pending")){
            throw new ApiException(ApiError.LOAN_VALIDATION_REJECTED_ERROR);
        }

        loan.setStatus("rejected");
        lr.save(loan);

        es.sendEmail(loan.getUser().getEmail(), "Rechazo de Préstamo", "Lamentamos informarle que su solicitud de préstamo del libro "+loan.getBook().getTitle()+" ha sido rechazada. Si tiene alguna pregunta o necesita más información, no dude en contactarnos.");
        
        return JsonApiResponse.builder()
                .message(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK.value())
                .data("Prestamo Rechazado con exito")
                .build();
    }

    @Override
    public JsonApiResponse returned(Long loanId) {

        Loan loan = lr.findById(loanId).orElseThrow(() -> new ApiException(ApiError.LOAN_BYID_NOT_FOUND));
        Book book = loan.getBook();

        if(!loan.getStatus().equals("aproved")){
            throw new ApiException(ApiError.LOAN_VALIDATION_ERROR);
        }

        loan.setStatus("returned");
        lr.save(loan);

        book.setAvailable(book.getAvailable() + 1);
        br.save(book);

        return JsonApiResponse.builder()
                .message(HttpStatus.OK.getReasonPhrase())
                .code(HttpStatus.OK.value())
                .data("Prestamo Devuelto con exito")
                .build();
    }
    

    @Override
    public JsonApiResponse findAll() {

        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.loanToLoanDetailsDtos((List<Loan>)lr.findAll()))
                .build();
    }

    @Override
    public JsonApiResponse findByUserId(Long userId) {

        User user = ur.findById(userId).orElseThrow(() -> new ApiException(ApiError.USER_BYID_NOT_FOUND));
        List<Loan> loans = lr.findAllByUser_Id(user.getId());

        if(loans.isEmpty()){
            throw new ApiException(ApiError.LOAN_BYUSERID_NOT_FOUND);
        }

      
        return JsonApiResponse.builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(map.loanToLoanDetailsDtos(loans))
                .build();
    }

}
