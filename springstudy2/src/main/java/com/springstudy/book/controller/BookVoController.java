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
import org.springframework.web.servlet.ModelAndView;

import com.springstudy.book.service.BookVoService;
import com.springstudy.book.vo.BookVo;

@Controller
public class BookVoController {

	@Autowired
	BookVoService bookService;

	public BookVoController() {
		System.out.println("@Controller 스프링 자동 생성");
	}

	
	@GetMapping("/createVo")
	public String create() {
		return "createVo";
	}

	@PostMapping("/createVo")
	public ModelAndView createPost(BookVo bookVo) {
		// 값 받기 : @RequestParam 스프링이 자동으로 넣어줌
		System.out.println(bookVo);
		// service
		int rs = bookService.create(bookVo);

		ModelAndView mav = new ModelAndView();
		if(rs == 1) {
			mav.setViewName("redirect:/listVo");			
		}else {
			mav.setViewName("redirect:/createVo");
		}		

		return mav;
	}
	
	@RequestMapping(value = "/listVo")
	public ModelAndView list(@RequestParam Map<String, Object> map) {		

		// service
		List<BookVo> list = bookService.list(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list); // request.setAttribute("data",list)
		if (map.containsKey("keyword")) {  
			mav.addObject("keyword", map.get("keyword"));  
		}  
		mav.setViewName("listVo"); // list.jsp


		return mav;
	}

	@RequestMapping(value = "/detailVo")
	public ModelAndView detail(BookVo bookVo) {		
		System.out.println("detail param >>>>>>>" + bookVo);
		// service
		BookVo detail = bookService.detail(bookVo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detail); // request.setAttribute("data",list)
		mav.setViewName("detailVo"); // list.jsp

		return mav;
	}

	@RequestMapping(value = "/updateVo", method = RequestMethod.GET)  
	public ModelAndView update(BookVo bookVo) {  
		System.out.println("param >>>" + bookVo);// {bookId = 3}
		BookVo detailMap = bookService.detail(bookVo);  

		ModelAndView mav = new ModelAndView();  
		mav.addObject("data", detailMap);  
		mav.setViewName("updateVo");  
		return mav;  
	}  

	@RequestMapping(value = "/updateVo", method = RequestMethod.POST)  
	public ModelAndView updatePost(BookVo bookVo) {  
		
		ModelAndView mav = new ModelAndView();  

		boolean isUpdateSuccess = bookService.edit(bookVo);  
		if (isUpdateSuccess) {  
			int bookId = bookVo.getBook_id();
			System.out.println("bookId>>>" + bookId);
			mav.setViewName("redirect:/detailVo?book_id=" + bookId);  
		}else {  
			int bookId = bookVo.getBook_id();
			System.out.println("bookId>>>" + bookId);
			mav = this.update(bookVo);  
		}  

		return mav;  
	} 

	@RequestMapping(value = "/deleteVo", method = RequestMethod.POST)  
	public ModelAndView deletePost(BookVo bookVo) {  
		
		ModelAndView mav = new ModelAndView();  
    	boolean isDeleteSuccess = bookService.remove(bookVo);  
		
		if (isDeleteSuccess) {  
			mav.setViewName("redirect:/listVo");  
		}else {  
			int bookId = bookVo.getBook_id();   
			mav.setViewName("redirect:/detailVo?book_id=" + bookId);  
		}  
		return mav;  
	} 
	//	@PostMapping("/createVo")
//	public ModelAndView createPost(BookVo bookVo) {
//		// 값 받기 : @RequestParam 스프링이 자동으로 넣어줌
//		System.out.println(bookVo);
//		// service
//		int rs = bookService.create(bookVo);
//
//		ModelAndView mav = new ModelAndView();
//		if(rs == 1) {
//			mav.setViewName("redirect:/listVo");			
//		}else {
//			mav.setViewName("redirect:/createVo");
//		}		
///		return mav;
//	}

}
