package com.leopoldo.ebook.ebook.services.interfaces;

import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.Loan.LoanRequestCreateDto;

public interface ILoanServices {
    JsonApiResponse request(LoanRequestCreateDto loanCreateDto);
    JsonApiResponse approve(Long loanId);
    JsonApiResponse reject(Long loanId);
    JsonApiResponse returned(Long loanId);
    JsonApiResponse findAll();
    JsonApiResponse findByUserId(Long userId);
}
