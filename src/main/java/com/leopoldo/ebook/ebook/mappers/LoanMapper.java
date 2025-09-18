package com.leopoldo.ebook.ebook.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.leopoldo.ebook.ebook.dtos.Loan.LoanDetailsDto;
import com.leopoldo.ebook.ebook.models.Loan;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    List<LoanDetailsDto> loanToLoanDetailsDtos(List<Loan> loans);
    LoanDetailsDto loanToLoanDetailsDto(Loan loan);
}
