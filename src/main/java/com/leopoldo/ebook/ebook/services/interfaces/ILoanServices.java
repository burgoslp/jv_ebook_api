package com.leopoldo.ebook.ebook.services.interfaces;

import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.Loan.LoanCreateDto;

public interface ILoanServices {
    JsonApiResponse loanRequest(LoanCreateDto loanCreateDto);
}
