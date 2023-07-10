package com.book.BookDAO;

import com.book.bookPojo.bookInfo;

public interface bookDAO {
	
	public String bookInsert(bookInfo book);
	public String bookRetrive(String BookName);
	public void bookUpdate(String BookName);
	
	

}

