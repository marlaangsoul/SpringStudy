package com.springstudy.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springstudy.book.vo.BookVo;

@RestController // AJAX 전용
public class BookControllerApi {
	
	public BookControllerApi() {
		System.out.println(" BookControllerApi()");
	}
	
	@GetMapping("/test") // String 리턴
	public String test() {
		return "Hello Test";
	}
	
	@GetMapping("/votest") // Object 리턴 {k:v}
	public BookVo votest() {
		BookVo vo = new BookVo();
		vo.setBook_id(1);
		vo.setTitle("AJAX");
		vo.setCategory("JavaScript");
		vo.setPrice(10000);
		return vo;
	}
	
	@GetMapping("/listvotest") // 배열에 Object 리턴 [{k:v}]
	public List<BookVo> listvotest() {
		List<BookVo> list = new ArrayList<BookVo>();
		BookVo vo = new BookVo();		
		vo.setBook_id(1);
		vo.setTitle("AJAX");
		vo.setCategory("JavaScript");
		vo.setPrice(10000);
		list.add(vo);
		return list;
	}
	
}
