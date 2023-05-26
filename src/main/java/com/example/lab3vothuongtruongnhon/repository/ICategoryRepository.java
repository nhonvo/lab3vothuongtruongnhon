package com.example.lab3vothuongtruongnhon.repository;

import com.example.lab3vothuongtruongnhon.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
