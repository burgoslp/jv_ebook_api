package com.leopoldo.ebook.ebook.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.Loan.LoanCreateDto;
import com.leopoldo.ebook.ebook.services.interfaces.ILoanServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private ILoanServices ls;

    @PostMapping("/loanRequest")
    public ResponseEntity<JsonApiResponse> loanRequest(LoanCreateDto loanCreateDto) {
        
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(ls.loanRequest(loanCreateDto));
    }
    
}
