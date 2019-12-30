package com.Student.Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Student.bean.Student;

public class StudentDao 
{

	
public static Connection getconnection()
{
	
	Connection con=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://192.168.100.26:3306/group010", "group010", "welcome");
		System.out.println("Done");
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return con;
	
}

public static List<Student> getAllRecords(int mm)
{
	List<Student> list=new ArrayList<Student>();
	try{
		Connection con=getconnection();
		PreparedStatement ps=con.prepareStatement("select * from studentDetails,courseDetails where studentDetails.cid=courseDetails.ccid and studentDetails.prn=?");
		ps.setInt(1, mm);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			
			Student s=new Student();
			
			s.setPrn(rs.getInt(1));
			s.setFname(rs.getString(2));
			s.setLname(rs.getString(3));
			s.setCid(rs.getInt(4));
			s.setCname(rs.getString(6));
			s.setModuleno(rs.getInt(7));
			s.setCstart_date(rs.getInt(8));
			s.setCend_date(rs.getInt(9));
			list.add(s);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}


public static Student search(int mm){
	Student s=new Student();
	try{
		Connection con=getconnection();
		PreparedStatement ps=con.prepareStatement("select * from studentDetails,courseDetails where studentDetails.cid=courseDetails.ccid and studentDetails.prn=?");
		ps.setInt(1, mm);
		
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
						
			
			s.setPrn(rs.getInt(1));
			s.setFname(rs.getString(2));
			s.setLname(rs.getString(3));
			s.setCid(rs.getInt(4));
			s.setCname(rs.getString(6));
			s.setModuleno(rs.getInt(7));
			s.setCstart_date(rs.getInt(8));
			s.setCend_date(rs.getInt(9));
			
			
		}
	}catch(Exception e){System.out.println(e);}
	return s;
}

	
}
