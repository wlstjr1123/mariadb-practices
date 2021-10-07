package bookmall.dao.test;

import bookmall.dao.OrderBookDao;
import bookmall.vo.OrderBookVo;

public class OrderBookTest {

	public static void main(String[] args) {
		insertTest();

	}

	public static void insertTest() {
		OrderBookVo vo1 = new OrderBookVo();
		vo1.setOrderNo(1L);
		vo1.setBookNo(2L);
		vo1.setBookCount(2);
		
		OrderBookVo vo2 = new OrderBookVo();
		vo2.setOrderNo(2L);
		vo2.setBookNo(1L);
		vo2.setBookCount(1);
		
		OrderBookDao.getInstance().insert(vo1);
		OrderBookDao.getInstance().insert(vo2);
	}
	
	

}
