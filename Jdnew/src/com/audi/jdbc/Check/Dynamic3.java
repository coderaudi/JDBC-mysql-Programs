package com.audi.jdbc.Check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



import com.mysql.jdbc.Driver;

public class Dynamic3 {

public static void main(String[] args) throws Exception {
	Driver d1 = new Driver();
	DriverManager.registerDriver(d1);
	
	Connection dburl = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info?user=root&password=root");
	
	String query=" insert into student_data values ( ? , ? )";
	PreparedStatement pstmt =dburl.prepareStatement(query);
							pstmt.setInt(1,Integer.parseInt(args[0]));
							pstmt.setString(2, args[1]);
	     
							int exeque =pstmt.executeUpdate();
	System.out.println(exeque);
	
	if(dburl!=null)
		dburl.close();
	if(pstmt!=null) {
		pstmt.close();
	}
	
}

}
