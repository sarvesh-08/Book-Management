package com.bookstore.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bookstore.library.entity.MyBook;

@Repository
public interface MyBookRepo extends JpaRepository<MyBook, Integer>{

}
