package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Books")
public class Book {
	@Id
	@Column(name = "book_id")
	private String id;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "book_genere")
	private String bookGenre;
	
	public Book() {
		
	}
	
	public Book(String id, String bookName, String bookGenre) {
		this.id = id;
		this.bookName = bookName;
		this.bookGenre = bookGenre;
	}

	public String getBookId() {
		return id;
	}
	

	public void setBookId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	
	
	
}
