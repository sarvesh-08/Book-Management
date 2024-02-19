package com.bookstore.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.bookstore.library.entity.Book;
import com.bookstore.library.repository.LibraryRepo;

@Service
public class LibraryService {

	@Autowired
	LibraryRepo bookRepo;
	
	public void save(Book b) {
		bookRepo.save(b);
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book getBook(int id) {
		return bookRepo.findById(id).get();
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}
}
