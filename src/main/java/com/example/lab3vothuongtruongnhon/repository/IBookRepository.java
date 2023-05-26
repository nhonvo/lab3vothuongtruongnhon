package com.example.lab3vothuongtruongnhon.repository;

import com.example.lab3vothuongtruongnhon.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
}
