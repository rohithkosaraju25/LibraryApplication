package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.exception.BookAlreadyExistsException;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping(value="/add",consumes="application/json")
	public ResponseEntity<String> saveBook(@RequestBody Book book) throws BookAlreadyExistsException{
		Optional<Book> myBook = bookService.getBookByBookId(book.getBookId());
		if(myBook.isPresent()) {
			throw new BookAlreadyExistsException("Book Already Exists");
		}
		else {
			bookService.saveBook(book.getBookId(), book.getBookName(), book.getBookGenre());
			return new ResponseEntity<String>("Book Added Succesfully",HttpStatus.ACCEPTED);
		}
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable("id") String id) throws BookNotFoundException{
		Optional<Book> myBook = bookService.getBookByBookId(id);
		if(myBook.isPresent()) {
			bookService.deleteBookById(id);
			return new ResponseEntity<String>("Book Deleted Suucessfully",HttpStatus.OK);
		}
		else {
			throw new BookNotFoundException("Book Not Found");
		}
		
	}
	
	@GetMapping(value="/byId/{id}",produces="application/json")
	public ResponseEntity<Book> getBookByBookId(@PathVariable("id") String id) throws BookNotFoundException{
		Optional<Book> myBook = bookService.getBookByBookId(id);
		if(myBook.isPresent()) {
			return new ResponseEntity<Book>(myBook.get(),HttpStatus.OK);
		}
		else {
			throw new BookNotFoundException("Book Not Found");
		}
		
	}
	
	@GetMapping(value="byName/{name}",produces="application/json")
	public ResponseEntity<List<Book>> getBookByBookName(@PathVariable("name") String name) throws BookNotFoundException {
		Optional<List<Book>> myBooks = bookService.getBookbyBookName(name);
		if(myBooks.isPresent()) {
			return new ResponseEntity<List<Book>>(myBooks.get(),HttpStatus.OK);
		}
		else {
			throw new BookNotFoundException("Book Not Found");
		}
	}
	
	@GetMapping(value="byGenre/{genre}",produces="application/json")
	public ResponseEntity<List<Book>> getBookByBookGenre(@PathVariable("genre") String genre) throws BookNotFoundException {
		Optional<List<Book>> myBooks = bookService.getBookByBookGenre(genre);
		if(myBooks.isPresent()) {
			return new ResponseEntity<List<Book>>(myBooks.get(),HttpStatus.OK);
		}
		else {
			throw new BookNotFoundException("Book Not Found Exception");
		}
		
	}
	
	@PutMapping(value="/changeGenre",consumes="application/json")
	public ResponseEntity<String> changeGenre(@RequestParam String id,@RequestParam String genre) throws BookNotFoundException{
		Optional<Book> myBook = bookService.getBookByBookId(id);
		if(myBook.isPresent()) {
			bookService.changeGenre(id, genre);
			return new ResponseEntity<String>("Changed Sucessfully",HttpStatus.OK);
		}
		else {
			throw new BookNotFoundException("Book Not Found");
		}
	}
	

}
