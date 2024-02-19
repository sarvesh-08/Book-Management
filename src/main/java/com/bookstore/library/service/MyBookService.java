package com.bookstore.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.library.entity.MyBook;
import com.bookstore.library.repository.MyBookRepo;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepo repo;
	
	public void addBook(MyBook b) {
		repo.save(b);
	}
	
	public List<MyBook> getAll() {
		return repo.findAll();
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	public MyBook getId(int id) {
		return repo.findById(id).get();
	}
}
