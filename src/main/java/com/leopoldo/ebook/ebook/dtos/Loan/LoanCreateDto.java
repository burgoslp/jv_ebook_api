package com.leopoldo.ebook.ebook.dtos.Loan;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoanCreateDto {

    @NotNull
    private Long userId;
    @NotNull
    private Long bookId;

    private LocalDateTime localDate;
    
    private LocalDateTime returnDate;

    private String status; // pending, aproved, rejected
}
