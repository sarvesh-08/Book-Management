package com.bookstore.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.library.entity.Book;
import com.bookstore.library.entity.MyBook;
import com.bookstore.library.service.LibraryService;
import com.bookstore.library.service.MyBookService;

@Controller
public class LibraryController {

	@Autowired
	LibraryService service;
	@Autowired
	MyBookService myBookService;
	
	@GetMapping("/")
	public String home(){
		return "home";
	}
	
	@GetMapping("/bookregister")
	public String register(){
		return "book_register";
	}
	
	@GetMapping("/availbooks")
	public ModelAndView getAllBooks(){
		ModelAndView m = new ModelAndView();
		List<Book> list =service.getAllBooks(); 
		m.addObject("book",list);
		m.setViewName("available_books");
		
		return m;
		
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b){
	
		service.save(b);
		return "redirect:/availbooks";
	}
	
	@GetMapping("/mybooks")
	public String myBooks(Model model) {
		List<MyBook> list = myBookService.getAll();
		model.addAttribute("book",list);
		
		return "my_books";
	}
	
	@RequestMapping("/mybookslist/{id}")
	public String myBookAdded(@PathVariable("id") int id) {
		
		Book b=service.getBook(id);
		MyBook mb =new MyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.addBook(mb);
		//ModelAndView m = new ModelAndView();
		return "redirect:/mybooks";
	}
	
	@RequestMapping("/deleteid/{id}")
	public String deleteById(@PathVariable("id") int id) {
		service.deleteBook(id);
		return "redirect:/availbooks";
	}
	@RequestMapping("/deletebookid/{id}")
	public String deleteBookById(@PathVariable("id") int id) {
		myBookService.deleteById(id);
		return "redirect:/mybooks";
	}
	@RequestMapping("/editid/{id}")
	public String editById(@PathVariable("id") int id,Model model) {
		Book mb=service.getBook(id);
		
		model.addAttribute("book",mb);
		return "editPage";
	}
	
}
