package com.springstudy.book.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springstudy.book.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	public BookController() {
		System.out.println("@Controller 스프링 자동 생성");
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/create")
	public String create() {
		return "create";
	}
	

	@PostMapping("/create")
	public ModelAndView createPost(@RequestParam Map<String, String> map) {
		// 값 받기 : @RequestParam 스프링이 자동으로 넣어줌
		System.out.println(map);
		// service
		int rs = bookService.create(map);

		ModelAndView mav = new ModelAndView();
		if(rs == 1) {
			mav.setViewName("redirect:/list");			
		}else {
			mav.setViewName("redirect:/create");
		}		

		return mav;
	}

	@RequestMapping(value = "/list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {		

		// service
		List<Map<String, Object>> list = bookService.list(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list); // request.setAttribute("data",list)
		if (map.containsKey("keyword")) {  
			mav.addObject("keyword", map.get("keyword"));  
		}  
		mav.setViewName("list"); // list.jsp


		return mav;
	}
	
	@GetMapping("/listRequest")
	public String listRequest() {
		return "listJson";
	}
	
	@RequestMapping(value = "/listJson")
	@ResponseBody
	public List<Map<String, Object>> listJson(@RequestParam Map<String, Object> map) {		

		// service
		List<Map<String, Object>> list = bookService.list(map);
		for(Map m : list) {
			System.out.println(m);
		}
		return list;
	}
	
	//  http://localhost:8080/book/detail?bookId=1
	@RequestMapping(value = "/detail")
	public ModelAndView detail(@RequestParam Map<String, Object> map) {		
		System.out.println("detail param >>>>>>>" + map);
		// service
		Map<String, Object> detail = bookService.detail(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detail); // request.setAttribute("data",list)
		mav.setViewName("detail"); // list.jsp

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)  
	public ModelAndView update(@RequestParam Map<String, Object> map) {  
		System.out.println("param >>>" + map);// {bookId = 3}
		Map<String, Object> detailMap = bookService.detail(map);  

		ModelAndView mav = new ModelAndView();  
		mav.addObject("data", detailMap);  
		mav.setViewName("update");  
		return mav;  
	}  

	@RequestMapping(value = "/update", method = RequestMethod.POST)  
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {  
		ModelAndView mav = new ModelAndView();  

		boolean isUpdateSuccess = bookService.edit(map);  
		if (isUpdateSuccess) {  
			String bookId = map.get("bookId").toString();  
			mav.setViewName("redirect:/detail?bookId=" + bookId);  
		}else {  
			mav = this.update(map);  
		}  

		return mav;  
	} 

	@RequestMapping(value = "/delete", method = RequestMethod.POST)  
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {  
		ModelAndView mav = new ModelAndView();  

		boolean isDeleteSuccess = bookService.remove(map);  
		if (isDeleteSuccess) {  
			mav.setViewName("redirect:/list");  
		}else {  
			String bookId = map.get("bookId").toString();  
			mav.setViewName("redirect:/detail?bookId=" + bookId);  
		}  

		return mav;  
	} 


}
