package com.audi.jdbc.Check;

import com.mysql.jdbc.Driver;
import java.sql.*;

public class Demo {
public static void main(String[] args) throws Exception {
	Driver d1 = new Driver();
	DriverManager.registerDriver(d1);
	
	Connection dburl = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info?user=root&password=root");
	
	String query="select * from student_data";
	Statement stmt=dburl.createStatement();
	ResultSet rs=stmt.executeQuery(query);
	
	while(rs.next()) {
		System.out.println(rs.getInt("ROLL"));
		System.out.println(rs.getString("NAME"));
	
		}
	
	if(dburl!=null)
		dburl.close();
	if(stmt!=null) {
		stmt.close();
	}
	if(rs!=null)
	{
		rs.close();
	}
}


	
}
