package com.book.bookQuery;

public interface Query {
    public String USER_INSERT_QUERY = "insert into book(bname,btype,bprice)values(?,?,?)";
	public String USER_SELECT_QUERY = "select *from book";
	public String BOOK_UPDATE_QUERY = "UPDATE book SET bname = ?, btype = ?, bprice = ? WHERE bname = ?";
	public String BOOK_DELETE_QUERY = "DELETE FROM book WHERE bname = ?";
}
