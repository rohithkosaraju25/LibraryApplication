package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Book;


public interface IBookService {
	public void saveBook(String id, String name, String genre) ;
	public Optional<Book> getBookByBookId(String id) ;
	public Optional<List<Book>> getBookbyBookName(String name);
	public Optional<List<Book>> getBookByBookGenre(String genre) ;
	public void changeGenre(String id,String genre);
	public void deleteBookById(String id);

}
