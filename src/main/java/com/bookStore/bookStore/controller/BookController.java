package com.bookStore.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.myBookList;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.myBookListService;

@Controller
public class BookController {
	@Autowired
	private myBookListService myBookService;
	
	@Autowired
	private BookService service;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
    @GetMapping("/book_register")
    public  String BookRegister() {
    	return "BookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllbook() {
    	List<Book>list=service.getAllBook();
//    	ModelAndView m= new ModelAndView();      
//    	m.setViewName("bookList");                   OR the just return part...
//    	m.addObject("book",list);
    	return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
    	service.save(b);
    	return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
    	List<myBookList>list = myBookService.getAllMyBooks();
    	model.addAttribute("book",list);
    	return "myBooks";
    }
    
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
    	Book b = service.getBookbyid(id);
    	myBookList mb= new myBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
    	myBookService.saveMyBooks(mb);
    	return "redirect:/my_books";
    }
}
