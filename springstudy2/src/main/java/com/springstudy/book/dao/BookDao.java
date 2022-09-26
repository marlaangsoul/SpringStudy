package com.springstudy.book.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public BookDao() {
		System.out.println("@Repository 스프링 자동생성");
	}

	public int insert(Map<String, String> map) {		
		return sqlSessionTemplate.insert("book.insert",map);		
	}

	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		
		return sqlSessionTemplate.selectList("book.select_list", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map) {
		
		return sqlSessionTemplate.selectOne("book.select_detail", map);
	}
	
	public int update(Map<String, Object> map) {  
		return sqlSessionTemplate.update("book.update", map); 
	} 
	
	public int delete(Map<String, Object> map) {  
		return this.sqlSessionTemplate.delete("book.delete", map);  
	} 
}
