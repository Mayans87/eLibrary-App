package com.bookStore.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookStore.entity.myBookList;
import com.bookStore.bookStore.repository.MyBookRepository;

@Service
public class myBookListService {
	@Autowired
	private MyBookRepository mybook;

	
	public void saveMyBooks(myBookList book) {
		
				mybook.save(book);
	}
	public List<myBookList> getAllMyBooks(){
		return mybook.findAll();
	}
    public void deleteById(int id) {
    	mybook.deleteById(id);
    }
}
