package com.bookStore.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.bookStore.service.myBookListService;



@Controller
public class mybooklistcontroller {
	
	@Autowired
	private myBookListService service;
	
	
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable ("id")int id) {
		service.deleteById(id);
		return "redirect:/my_books";
	}

}
