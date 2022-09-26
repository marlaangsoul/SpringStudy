package com.springstudy.book.vo;


public class BookVo {
	
	private int book_id; 
	private String title; 
	private String category;
	private int price;
	private String insert_date;
	
	public BookVo() {
	}

	public BookVo(int book_id, String title, String category, int price, String insert_date) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.insert_date = insert_date;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

	@Override
	public String toString() {
		return "BookVo [book_id=" + book_id + ", title=" + title + ", category=" + category + ", price=" + price
				+ ", insert_date=" + insert_date + "]";
	}

		
	
}
