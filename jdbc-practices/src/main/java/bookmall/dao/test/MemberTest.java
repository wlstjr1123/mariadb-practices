package bookmall.dao.test;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberTest {

	public static void main(String[] args) {
		insertTest();

	}

	public static void insertTest() {
		MemberVo vo1 = new MemberVo();
		vo1.setName("둘리");
		vo1.setPhoneNumber("11111111111");
		vo1.setEmail("enffl@gmail.com");
		vo1.setPassword("1234");
		
		MemberVo vo2 = new MemberVo();
		vo2.setName("또치");
		vo2.setPhoneNumber("22222222222");
		vo2.setEmail("Ehcl@gmail.com");
		vo2.setPassword("5678");
		
		MemberDao.getInstance().insert(vo1);
		MemberDao.getInstance().insert(vo2);
		
	}

}
