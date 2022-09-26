package com.springstudy.book.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springstudy.book.vo.BookVo;

@Repository
public class BookVoDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public BookVoDao() {
		System.out.println("@Repository 스프링 자동생성");
	}

	public int insert(BookVo bookVo) {		
		return sqlSessionTemplate.insert("bookVo.insert",bookVo);		
	}
	
	public List<BookVo> selectList(Map<String, Object> map) {
		
		return sqlSessionTemplate.selectList("bookVo.select_list", map);
	}
	
	public BookVo selectDetail(BookVo bookVo) {
		
		return sqlSessionTemplate.selectOne("bookVo.select_detail", bookVo);
	}
	
	public int update(BookVo bookVo) {  
		return sqlSessionTemplate.update("bookVo.update", bookVo); 
	} 
	
	public int delete(BookVo bookVo) {  
		return this.sqlSessionTemplate.delete("bookVo.delete", bookVo);  
	} 

}
