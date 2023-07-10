package com.book.BookImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.book.bookQuery.Query;


import com.book.bookConfigure.jdbcUtility;
import com.book.bookPojo.bookInfo;

public class bookDaoImpl {
    private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public String bookInsert(bookInfo book) {
		String message = "";
		try {
			con = jdbcUtility.getConnection();
			ps = con.prepareStatement(Query.USER_INSERT_QUERY);
			ps.setString(1,book.getBname());
			ps.setString(2,book.getBtype());
			ps.setInt(3, book.getBprice());
			int count = ps.executeUpdate();
			if(count != 0) {
				message = "Registration Suscessfully"; 
			}
			else 
				message = "Registration is not Suscessfully";
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return message;
	}

	public String bookRetrive(String BookName) {
		
		try {
			
			con = jdbcUtility.getConnection();
			ps = con.prepareStatement(Query.USER_SELECT_QUERY);
			rs = ps.executeQuery();
			while (rs.next()) {
			
				String bookName = rs.getString("bname");
				String bookType = rs.getString("btype");
				int bookPrice = rs.getInt("bprice");
				if (bookName.equals(BookName)) {
					String BookInfo = 
							"bookName: "+ bookName +"\n"
							+ "bookType: "+bookType+"\n"
							+ "bookPrice: "+bookPrice;
				return BookInfo;}
				
			
			}
				
				
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				jdbcUtility.closeConnection(con,ps,rs);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null ;
	}

	public void bookUpdate(String bookname) {
		Scanner in = new Scanner(System.in);
		try {
			con = jdbcUtility.getConnection();
			
		
			ps = con.prepareStatement(Query.USER_SELECT_QUERY);
			rs = ps.executeQuery();
			boolean bookFound = false;
			while (rs.next()) {
				
				String bookName = rs.getString("bname");
				String bookType = rs.getString("btype");
				int bookPrice = rs.getInt("bprice");
				
				if (bookName.equals(bookname)) {
					bookFound = true;
					
				
				
			System.out.println("Enter a new BookName to update");
			String newBook = in.next();
			System.out.println("Enter a new BookType to update");
			String newType = in.next();
			System.out.println("Enter a new BookPrice to update");
			int newPrice = in.nextInt();
			
			ps = con.prepareStatement(Query.BOOK_UPDATE_QUERY);
			ps.setString(1,newBook);
			ps.setString(2,newType);
			ps.setInt(3, newPrice);
			ps.setString(4,bookName);
				
			int count = ps.executeUpdate();
			if(count != 0) {
				System.out.println("Book updated Successfully");
				}
			else {
				System.out.println("Falied to Update");
			}
			break;
				}
			}
			if(!bookFound) {
				System.out.println("Book Not Found");
			}
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				jdbcUtility.closeConnection(con,ps);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
    
}
