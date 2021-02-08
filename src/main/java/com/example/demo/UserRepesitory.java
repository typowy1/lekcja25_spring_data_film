package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepesitory extends JpaRepository<User, Long> { // jako 1 parametr podajemy klasę, jako 2 parametr podajemy identyfikator
    //zarządzenie klasa user, zarządza urzytownikami

    //lepiej po nazwach
    // za pomocą tworzenia przez nazwy, spring data po nazwie wykona metode,w dokumentacji są różne metody tworzenia zapytań
    List<User> findAllByGenderOrderByNameDesc(Gender gender);

    //za pomocą tworzenia przez query psql
    @Query("SELECT u FROM User u WHERE u.gender = :gender ORDER BY u.name desc")
    List<User> findAllByGenderOrderByNameDesc1(@Param("gender") Gender gender);

    //za pomocą tworzenia przez query sql
    @Query(value = "SELECT * FROM user WHERE gender = LIKE ?1 ORDER BY name desc", nativeQuery = true)
    List<User> findAllByGenderOrderByNameDesc12(@Param("gender") Gender gender);
}
