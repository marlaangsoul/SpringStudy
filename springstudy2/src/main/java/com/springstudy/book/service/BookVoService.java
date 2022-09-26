package com.springstudy.book.service;

import java.util.List;
import java.util.Map;

import com.springstudy.book.vo.BookVo;

public interface BookVoService {
	
	public int create(BookVo bookVo);
	
	public List<BookVo> list(Map<String, Object> map);

	public BookVo detail(BookVo bookVo);

	public boolean edit(BookVo bookVo);

	public boolean remove(BookVo bookVo);
}
