package com.leopoldo.ebook.ebook.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @Column(name = "birth_date", columnDefinition = "DATE")
    @NotBlank
    private LocalDate birthDate;
    @NotBlank
    private String nationality;
    @Column(length = 1000)
    @NotBlank
    private String biography;
    @NotBlank
    @Column(columnDefinition = "DATETIME")
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String image;
    @ManyToMany(cascade =  {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> books;




    
}
