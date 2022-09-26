package com.springstudy.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.book.dao.BookVoDao;
import com.springstudy.book.vo.BookVo;

@Service
public class BookVoServiceImpl implements BookVoService{
	
	@Autowired
	BookVoDao dao;
	
	public BookVoServiceImpl() {
		System.out.println("@Service 스프링 자동 생성");
	}

	@Override
	public int create(BookVo bookVo) {
		return dao.insert(bookVo);
	}
	
	@Override
	public List<BookVo> list(Map<String, Object> map) {
		return dao.selectList(map);
	}
	
	@Override
	public BookVo detail(BookVo bookVo) {
		return dao.selectDetail(bookVo);
	}
	
	@Override  
	public boolean edit(BookVo bookVo) {  
	    return dao.update(bookVo) == 1;
	}
	
	@Override
	public boolean remove(BookVo bookVo) {  
	    return dao.delete(bookVo) == 1;
	} 
	
	
	
	
	
}
