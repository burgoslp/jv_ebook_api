package com.leopoldo.ebook.ebook.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.leopoldo.ebook.ebook.dtos.Json.JsonApiResponse;
import com.leopoldo.ebook.ebook.dtos.Loan.LoanRequestCreateDto;
import com.leopoldo.ebook.ebook.services.interfaces.ILoanServices;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @Autowired
    private ILoanServices ls;

    @GetMapping()
    public ResponseEntity<JsonApiResponse> findAll() {
        return ResponseEntity.status(HttpStatus.OK.value()).body(ls.findAll());
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<JsonApiResponse> findByUserId(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(ls.findByUserId(userId));
    }

    @PostMapping("/request")
    public ResponseEntity<JsonApiResponse> request(@Valid @RequestBody LoanRequestCreateDto loanRequestCreateDto) {
        
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(ls.request(loanRequestCreateDto));
    }

    @PostMapping("/rejected/{id}")
    public ResponseEntity<JsonApiResponse> reject(@PathVariable Long id) {
        
        return ResponseEntity.status(HttpStatus.OK.value()).body(ls.reject(id));
    }

    @PostMapping("aprove/{id}")
    public ResponseEntity<JsonApiResponse> aprove(@PathVariable Long id) {
       
        return  ResponseEntity.status(HttpStatus.OK.value()).body(ls.approve(id));
    }
    
    @PostMapping("/returned/{id}")
    public ResponseEntity<JsonApiResponse> returned(@PathVariable Long id) {
        
        return ResponseEntity.status(HttpStatus.OK.value()).body(ls.returned(id));
    }
    
}
