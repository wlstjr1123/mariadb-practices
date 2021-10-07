package bookmall.dao.test;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookTest {
	public static void main(String[] args) {
		insertTest();
	}

	public static void insertTest() {
		BookVo vo1 = new BookVo();
		vo1.setCategoryNo(1);
		vo1.setTitle("불편한 편의점");
		vo1.setPrice(20000);
		
		BookVo vo2 = new BookVo();
		vo2.setCategoryNo(2);
		vo2.setTitle("시나공 정보처리기사");
		vo2.setPrice(25000);
		
		BookVo vo3 = new BookVo();
		vo3.setCategoryNo(3);
		vo3.setTitle("부의 시나리오");
		vo3.setPrice(30000);
		
		BookDao.getInstance().insert(vo1);
		BookDao.getInstance().insert(vo2);
		BookDao.getInstance().insert(vo3);
	}
}
