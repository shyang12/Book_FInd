package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RestAPI {

	private List<Book> bookList = new ArrayList<>();
	
	@RequestMapping(method = RequestMethod.GET, path = "/books")
	public List<Book> GetAll() {
		return bookList;
	}
	// json을 받기 때문에 @RequestBody Book book을 적어줌
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, path = "/add")
	public String Add(@RequestBody Book book) {
		bookList.add(book);
		return "Add";
	}
	// @PathVariable를 사용하면 동적 path를 자동으로 파싱한다.
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.GET}, path = "/update/{id}")
	public String Update(@RequestBody Book tobook, @PathVariable int id) {
		
		Book find_book = bookList.stream()
				.filter(book -> book.getId() == id)
				.findAny()
				.orElse(null);
		
		if (find_book != null) {
			find_book.setAuthor(tobook.getAuthor());
			find_book.setName(tobook.getName());
			find_book.setPrice(tobook.getPrice());
			
			return "success";
		}
		return "not valid";
	}
	
	@RequestMapping(method = {RequestMethod.DELETE, RequestMethod.GET}, path = "/delete/{id}")
	public String Delete(@PathVariable int id) {
		
		Book find_book = bookList.stream()
				.filter(book -> book.getId() == id)
				.findAny()
				.orElse(null);
		
		if (find_book != null) {
			bookList.remove(find_book);
			return "success";
		}
		
		return "not valid";
	}
}
