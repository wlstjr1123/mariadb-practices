package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest02 {

	public static void main(String[] args) {
		insert("영업");
		insert("개발");
		insert("기획");

	}

	private static boolean insert(String name) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver"); //클래스를 직접 로딩
			
			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			// 3. sql문 준비
			String sql = "insert into dept values(null, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setString(1, name);
			
			// 4. SQL 실행
			
			int count = pstmt.executeUpdate(sql);
			
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
