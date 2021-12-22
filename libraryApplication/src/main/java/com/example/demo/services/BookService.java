package com.example.demo.services;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Book;
import com.example.demo.repository.IBookRepository;

@Service
public class BookService implements IBookService {

	@Autowired
	IBookRepository bookDao;
	
	
	@Override
	public void saveBook(String id, String name, String genre) {
		Book myBook = new Book(id,name,genre);
		bookDao.save(myBook);

	}
	
	
	@Override
	public Optional<Book> getBookByBookId(String id) {
		Optional<Book> myBooks = bookDao.findById(id);
		return myBooks;
	}

	@Override
	public Optional<List<Book>> getBookbyBookName(String name)  {
		Optional<List<Book>> myBooks = bookDao.findByBookName(name);
		return myBooks;
	}

	@Override
	public Optional<List<Book>> getBookByBookGenre(String genre)  {
		Optional<List<Book>> myBooks = bookDao.findByBookGenre(genre);
		return myBooks;
	}

	@Override
	public void changeGenre(String id,String genre) {
		Optional<Book> myBook = bookDao.findById(id);
		if(myBook.isPresent()) {
			myBook.get().setBookGenre(genre);
		}

	}

	@Override
	public void deleteBookById(String id) {
		Optional<Book> myBook = bookDao.findById(id);
		if(myBook.isPresent()) {
			bookDao.deleteById(id);
		}

	}

}
