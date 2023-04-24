package com.bookStore.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository brepo;
	
	public void save(Book b) {
		brepo.save(b);
	}
	public List<Book>getAllBook(){
		return brepo.findAll();
	}
    public Book getBookbyid(int id) {
    	return brepo.findById(id).get();
    	
    }
}
