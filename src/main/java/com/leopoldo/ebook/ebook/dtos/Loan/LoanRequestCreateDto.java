package com.leopoldo.ebook.ebook.dtos.Loan;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoanRequestCreateDto {

    @NotNull
    private Long userId;
    @NotNull
    private Long bookId;

}
