package com.path.conn;

import java.sql.*;

import com.mysql.jdbc.*;

public class Connection {
	 
	public static java.sql.Connection getConn() throws Exception{
	     String connectionUrl = "jdbc:mysql://192.168.86.11:3306/path_toll_new";
	     java.sql.Connection con = DriverManager.getConnection(connectionUrl, "root", "sZc5wSsgn3S");
		 return con;
	}
}




	
//FileReader reader=new FileReader("db.properties");  
//
//Properties p=new Properties();  
//p.load(reader);  
//  
//System.out.println(p.getProperty("user"));  
//System.out.println(p.getProperty("password")); 

