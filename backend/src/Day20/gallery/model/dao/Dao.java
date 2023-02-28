package Day20.gallery.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.protocol.Resultset;

public class Dao {
	//1. JDBC 인터페이스 3개
	public Connection con; // DB 연동 인터페이스
	public PreparedStatement ps; // SQL 조작 인터페이스
	public Resultset rs; // SQL 결과 조작 인터페이스
	
	
	public Dao() { //DB연동
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/boardDB","root","1234");
		}
		catch (Exception e) {System.out.println("연동 실패 : " + e);}
	}// 빈 생성자 e
}
