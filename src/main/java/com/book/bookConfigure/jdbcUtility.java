package com.book.bookConfigure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtility {
    private static Connection con =null;
	
	public static Connection getConnection() throws FileNotFoundException,IOException, ClassNotFoundException,SQLException
	{
		Properties pro =   new Properties();
		//Step 1": register Driver 
		
		pro.load(new FileInputStream("C:\\Users\\tenzi\\eclipse-workspace\\BookManagementSystem\\src\\main\\java\\com\\book\\Properties\\app.Properties"));
		Class.forName(pro.getProperty("dbClass"));
		
		con = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("dbuname"),pro.getProperty("dbpassword"));
		
		
		return con;
	}
	public static void closeConnection(Connection con,PreparedStatement ps) throws SQLException{
		
		if(ps!=null)
			ps.close();     
		if(con!=null)
			con.close();
	}
		
	public static void closeConnection(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException{
		if(rs !=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close();
			
	}

    
}
