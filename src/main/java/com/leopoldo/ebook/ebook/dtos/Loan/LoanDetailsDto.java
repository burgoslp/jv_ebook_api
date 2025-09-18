package com.leopoldo.ebook.ebook.dtos.Loan;

import com.leopoldo.ebook.ebook.dtos.Book.BookSumaryDto;
import com.leopoldo.ebook.ebook.dtos.User.UserSumaryDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoanDetailsDto {

    Long id;
    UserSumaryDto user;
    BookSumaryDto book;
    String status;
    String requestDate;
    String loanDate;
    String returnDate;

}
