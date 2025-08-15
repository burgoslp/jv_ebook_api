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
import jakarta.persistence.OneToMany;
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
@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String title;
    @Column(name = "publication_date", columnDefinition = "DATE")
    @NotNull
    private LocalDate publicationDate;
    @NotBlank
    private String publisher;
    @NotBlank
    @Column(unique = true)
    private String isbn;
    @NotBlank
    @Column(length = 1000)
    private String synopsis;
    @NotBlank
    private String cover;

    //relaciones
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToMany(mappedBy = "books")
    private List<Category> categories;

    @ManyToMany(mappedBy = "books")
    private List<User> usersWithBookInLibrary;

    @ManyToMany(mappedBy = "likes")
    private List<User> usersWhoLiked;

}   
