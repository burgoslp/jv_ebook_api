package com.leopoldo.ebook.ebook.models;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany(cascade =  {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> books;

    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotNull
    @Column(name = "birth_date", columnDefinition = "DATETIME")
    private LocalDateTime birthDate;


    @Column(length = 1000)
    @NotBlank
    private String biography;

    private String image;
    
    @NotNull
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime updatedAt; 
}
