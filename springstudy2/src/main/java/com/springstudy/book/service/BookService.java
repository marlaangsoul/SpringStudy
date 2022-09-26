package com.springstudy.book.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	
	public int create(Map<String, String> map);

	public List<Map<String, Object>> list(Map<String, Object> map);

	public Map<String, Object> detail(Map<String, Object> map);

	public boolean edit(Map<String, Object> map);

	public boolean remove(Map<String, Object> map);

}
