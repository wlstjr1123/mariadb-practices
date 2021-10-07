package bookmall.dao.test;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;

public class OrderTest {

	public static void main(String[] args) {
		insertTest();

	}

	public static void insertTest() {
		OrderVo vo1 =  new OrderVo();
		vo1.setMemberNo(2L);
		vo1.setOrderNo("202110071887");
		vo1.setPayment(25000);
		vo1.setOrderName("또치");
		
		OrderVo vo2 =  new OrderVo();
		vo2.setMemberNo(1L);
		vo2.setOrderNo("202110079987");
		vo2.setPayment(20000);
		vo2.setOrderName("둘리");
		
		OrderDao.getInstance().insert(vo1);
		OrderDao.getInstance().insert(vo2);
	}

}
