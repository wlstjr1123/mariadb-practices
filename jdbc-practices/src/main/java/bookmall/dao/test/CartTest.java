package bookmall.dao.test;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartTest {

	public static void main(String[] args) {
		insertTest();

	}

	public static void insertTest() {
		CartVo vo1 = new CartVo();
		vo1.setBookNo(1L);
		vo1.setMemberNo(2L);
		vo1.setBookCount(2L);
		
		CartVo vo2 = new CartVo();
		vo2.setBookNo(2L);
		vo2.setMemberNo(2L);
		vo2.setBookCount(1L);
		
		CartDao.getInstance().insert(vo1);
		CartDao.getInstance().insert(vo2);
	}

}
