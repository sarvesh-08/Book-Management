package com.bookstore.library.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class MyBook {

	@Id

	private int id;
	private String name;
	private String author;
	private String price;

	public MyBook(int id, String name, String author, String price) {
		super();
		this.name = name;
		this.id = id;
		this.author = author;
		this.price = price;
	}

	public MyBook() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
