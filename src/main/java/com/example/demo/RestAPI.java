package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI {

	@RequestMapping(method = RequestMethod.GET, path = "/books")
	public String GetAll() {
		return "getall";
	}
	// json을 받기 때문에 @RequestBody Book book을 적어줌
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, path = "/add")
	public String Add(@RequestBody Book book) {
		return "Add";
	}
	// @PathVariable를 사용하면 동적 path를 자동으로 파싱한다.
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.GET}, path = "/update/{id}")
	public String Update(@RequestBody Book book, @PathVariable int id) {
		return "Update";
	}
	
	@RequestMapping(method = {RequestMethod.DELETE, RequestMethod.GET}, path = "/delete/{id}")
	public String Delete(@PathVariable int id) {
		return "Delete";
	}
}
