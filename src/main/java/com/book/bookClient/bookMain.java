package com.book.bookClient;

import java.util.Scanner;

import com.book.BookImpl.bookDaoImpl;
import com.book.bookPojo.bookInfo;

public class bookMain {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        bookDaoImpl dao = new bookDaoImpl(); // Create an instance of bookDaoImpl
        int i = 0;
        while(i == 0) {
        System.out.println("==================================================");
        System.out.println("\t\t1) Insert Book\n\t\t2) Retrieve Book\n\t\t3) Update Book");
        System.out.println("==================================================");
        System.out.print("Enter your choice: ");
        int choice = in.nextInt();
        
        
        switch (choice) {
            case 1:
            	System.out.println("Enter book Name");
            	String bookName = in.next();
            	
            	
            	System.out.println("Enter book Type");
            	String bookType = in.next();
            	
            	System.out.println("Enter book Price");
            	int bookPrice = in.nextInt();
            	
                bookInfo newBook = new bookInfo( bookName, bookType, bookPrice);
                // Set the attributes of the newBook object
                
                String insertResult = dao.bookInsert(newBook);
                System.out.println(insertResult);
                break;
            case 2:
                System.out.print("Enter the book Name ");
                String BName = in.next();
                
                String retrieveResult = dao.bookRetrive(BName);
                System.out.println(retrieveResult);
                break;
            case 3:
                System.out.print("Enter the book Name to update: ");
                String bookIdToUpdate = in.next();
                
                dao.bookUpdate(bookIdToUpdate);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        System.out.println("Enter 0 to do Over or 1 to Stop");
        i = in.nextInt();
}
in.close();
        
    }

    
}
