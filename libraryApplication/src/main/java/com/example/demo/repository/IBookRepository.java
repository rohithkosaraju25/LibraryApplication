package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book,String> {
	public Optional<List<Book>> findByBookName(String name);
	public Optional<List<Book>> findByBookGenre(String genre);
	public void deleteById(String id);
	}
