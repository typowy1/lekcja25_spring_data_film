package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // tak oznaczmy encje, encja to klasa która ma odpowiednik w bazie danych
public class User {
    // to jest nasza tabela, tworzenie tabeli ma miejsce w data.sql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to utworzy unikalny prymary key
    private Long id; // tabela już automatycznie się stworzy przy starcie aplikacji
    private String name;

    @Enumerated(EnumType.STRING)// do obsługi enuma
    private Gender gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
