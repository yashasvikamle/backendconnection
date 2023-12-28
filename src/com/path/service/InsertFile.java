package com.path.service;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class InsertFile {

	public static void main(String[] args) throws Exception {
		java.sql.Connection con = com.path.conn.Connection.getConn();
		System.out.println(con);
		
		
		Statement stmt=con.createStatement();
		//stmt.executeUpdate("delete from icd_logger where srno=2");
		//stmt.executeUpdate("update icd_logger set msg_id='1228' where srno=14");  
		//stmt.executeUpdate("INSERT INTO `icd_logger` (`api_name`, `msg_id`, `trx_time`, `req_time`, `res_time`, `req_status`, `file_name`, `date`) VALUES ('ReqPay', '2122', '2023-11-11 00:00:10', '2023-11-11 00:00:12', '2023-11-11 00:00:14', 'FAILED', 'A15BC.txt', '2023-11-12');");  
		String sql = "select * from icd_logger";
		ResultSet rs=stmt.executeQuery(sql);
		
       while(rs.next()){  
       System.out.println(" DB data : " + rs.getString(1) + " " + rs.getString(2)+" " + rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9));  
       }  
       
       
		/*
		FileReader fr=new FileReader("C:\\Users\\yasha\\OneDrive\\Desktop\\demo.txt");  
        BufferedReader br=new BufferedReader(fr);    
		System.out.println(br);

        String data;    
        while((data=br.readLine()) != null){  
        System.out.print("File data : " + data);  
        Statement stmt=con.createStatement();  
        String api_name = data.split(',')[0];
        
		
        }  
        br.close();    
        fr.close();    
        */
  }    
}    
