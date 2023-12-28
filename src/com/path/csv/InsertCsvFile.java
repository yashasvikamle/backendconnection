 package com.path.csv;
import java.io.FileReader;
import java.io.InputStream;
// import java.io.Writer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.BufferedReader;
import com.mysql.jdbc.PreparedStatement;
import java.util.Properties;
// import java.io.FileWriter;
import java.io.FileInputStream;
import java.util.ResourceBundle;


public class InsertCsvFile {
	public static void main(String args[])throws Exception {
		java.sql.Connection con = com.path.conn.Connection.getConn();
		System.out.println(con);
		
        //Statement smt= con.createStatement();
	
		FileReader fr = new FileReader("C:\\location.properties.txt");
	      Properties prop=new Properties();
	     prop.load(fr);  
		   
		    // prop.setProperty("username","root");
		   // prop.setProperty("password", "shh123");
           // prop.store(writer,"credentials");
		   
		    prop.getProperty("location");
			
		    
		    FileReader fr1 = new FileReader(prop.getProperty("location"));
            BufferedReader br = new BufferedReader(fr1);
         	System.out.println(br);
		
		
		String data;
		int lineNumber=0;
		
		while((data=br.readLine()) != null) {
			if (data.equals("") || lineNumber==0) {
	
			lineNumber++;
				continue;
		}
			    String tmp[]=data.split(",");
			    String api_name=tmp[1];
			    String msg_id=tmp[2];
			    String trx_time=tmp[3];
			    String req_time=tmp[4];
			    String res_time=tmp[5];
			    String req_status=tmp[6];
			    String file_name=tmp[7];
			    String date=tmp[8];
			   
			//String sql ="INSERT INTO `icd_logger` (`api_name`, `msg_id`, `trx_time`, `req_time`, `res_time`, `req_status`, `file_name`, `date`) VALUES ('"+api_name+"','"+msg_id+"','"+trx_time+"','"+req_time+"','"+res_time+"','"+req_status+"','"+file_name+"','"+date+"')";
			//String sql ="call byReqStat('"+api_name+"','"+msg_id+"','"+trx_time+"','"+req_time+"','"+res_time+"','"+req_status+"','"+file_name+"','"+date+"')";
			
			    String sql ="call insertQuery(?,?,?,?,?,?,?,?)";

			//prepared statements
			 java.sql.PreparedStatement stmt=con.prepareStatement(sql);
			 stmt.setString(1, api_name);
			 stmt.setString(2, msg_id);
			 stmt.setString(3, trx_time);
			 stmt.setString(4, req_time);
			 stmt.setString(5, res_time);
			 stmt.setString(6, req_status);
			 stmt.setString(7, file_name);
			 stmt.setString(8, date);

	        int status = stmt.executeUpdate();
	       
             //create statement
//			Statement smt= con.createStatement();
//
//		    int status = smt.executeUpdate(sql);
		   
	        if(status==1) {
				System.out.println("data is successfully inserted " + msg_id);
			} else {
				System.out.println("not successfully inserted " + msg_id);
			
			}
		
			lineNumber++;
		    
			System.out.println("data inserted : "+status);
			 
			
		//System.out.println("Data Insert status : " + status + "   Line No. " +lineNumber);
			 }		
		br.close();    
        fr.close();
      
	}

}






