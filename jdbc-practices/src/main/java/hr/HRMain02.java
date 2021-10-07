package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain02 {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("salary[min max]>");
		int minSalary = scanner.nextInt();
		int maxSalary = scanner.nextInt();
		
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVO> result = dao.findBySalary(minSalary, maxSalary);
		
		for (EmployeeVO vo : result) {
			System.out.println(vo.getNo() + ":" + vo.getFirstName() + ":" + vo.getLastName() + ":" + vo.getHireDate() + ":" + vo.getSalary());
		}
		
		scanner.close();
	}
}
