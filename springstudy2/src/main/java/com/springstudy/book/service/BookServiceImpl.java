package com.springstudy.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.book.dao.BookDao;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDao dao;
	
	public BookServiceImpl() {
		System.out.println("@Service 스프링 자동 생성");
	}

	@Override
	public int create(Map<String, String> map) {
		return dao.insert(map);
	}
	
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return dao.selectList(map);
	}
	
	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return dao.selectDetail(map);
	}
	
	@Override  
	public boolean edit(Map<String, Object> map) {  
	    return dao.update(map) == 1;
	}
	
	@Override
	public boolean remove(Map<String, Object> map) {  
	    return dao.delete(map) == 1;
	} 
	
	
	
}
