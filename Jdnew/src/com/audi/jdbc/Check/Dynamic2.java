package com.audi.jdbc.Check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;

public class Dynamic2 {


public static void main(String[] args) throws Exception {
	Driver d1 = new Driver();
	DriverManager.registerDriver(d1);
	
	Connection dburl = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info?user=root&password=root");
	
	String query="select * from student_data where ROLL= ?";
	PreparedStatement pstmt =dburl.prepareStatement(query);
							pstmt.setInt(1,Integer.parseInt(args[0]));
	     
							ResultSet rs=pstmt.executeQuery();
	
	while(rs.next()) {
		System.out.println(rs.getInt("ROLL"));
		System.out.println(rs.getString("NAME"));
	
		}
	
	if(dburl!=null)
		dburl.close();
	if(pstmt!=null) {
		pstmt.close();
	}
	if(rs!=null)
	{
		rs.close();
	}
}

}
