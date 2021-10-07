package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public List<EmployeeVO> findByName(String name) {
		List<EmployeeVO> result = new ArrayList<EmployeeVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver"); //클래스를 직접 로딩
			
			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			// 3. Statement 생성
			String sql = 
					"select emp_no, first_name, last_name, date_format(hire_date, '%Y-%m-%d') "
					+ "		from employees "
					+ "	where first_name like ? "
					+ "		or last_name like ?;";
			pstmt = conn.prepareStatement(sql);
			
			// 3.5
			pstmt.setString(1, "%" + name + "%");
			pstmt.setString(2, "%" + name + "%");
			
			// 4. SQL 실행
			
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String hireDate = rs.getString(4);
				
				EmployeeVO vo = new EmployeeVO();
				vo.setNo(empNo);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setHireDate(hireDate);
				
				result.add(vo);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// clean up
		}
		return result;
	}

	public List<EmployeeVO> findBySalary(int minSalary, int maxSalary) {
List<EmployeeVO> result = new ArrayList<EmployeeVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver"); //클래스를 직접 로딩
			
			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			// 3. Statement 생성
			String sql = 
					"select e.emp_no, e.first_name, e.last_name, date_format(e.hire_date, '%Y-%m-%d'), s.salary "
					+ "	from employees e join salaries s on e.emp_no = s.emp_no "
					+ " where s.salary between ? and ? "
					+ "		and s.to_date = '9999-01-01';";
			pstmt = conn.prepareStatement(sql);
			
			// 3.5
			pstmt.setInt(1, minSalary);
			pstmt.setInt(2, maxSalary);
			
			// 4. SQL 실행
			
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String hireDate = rs.getString(4);
				int salary = rs.getInt(5);
				
				EmployeeVO vo = new EmployeeVO();
				vo.setNo(empNo);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setHireDate(hireDate);
				vo.setSalary(salary);
				
				result.add(vo);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// clean up
		}
		return result;
	}

}
