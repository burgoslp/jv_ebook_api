package com.leopoldo.ebook.ebook.models;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="Loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime requestDate;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime loanDate;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime returnDate;

    @NotNull
    @Column(length = 20)
    private String status; // pending, aproved, rejected
}
