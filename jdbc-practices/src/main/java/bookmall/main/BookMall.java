package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderBookDao;
import bookmall.dao.OrderDao;
import bookmall.dao.test.BookTest;
import bookmall.dao.test.CartTest;
import bookmall.dao.test.CategoryTest;
import bookmall.dao.test.MemberTest;
import bookmall.dao.test.OrderBookTest;
import bookmall.dao.test.OrderTest;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class BookMall {
	public static void main(String[] args) {
		new CategoryTest().insertTest();
		new MemberTest().insertTest();
		new BookTest().insertTest();
		new CartTest().insertTest();
		new OrderTest().insertTest();
		new OrderBookTest().insertTest();
		
		System.out.println("=======================카테고리=======================");		
		List<CategoryVo> categoList = CategoryDao.getInstance().findAll();
		
		for (CategoryVo vo : categoList) {
			System.out.println(vo.toString());
		}
		
		System.out.println("=======================맴버=======================");
		List<MemberVo> memberList = MemberDao.getInstance().findAll();
		
		for (MemberVo vo : memberList) {
			System.out.println(vo.toString());
		}
		
		System.out.println("=======================상품=======================");
		List<BookVo> bookList = BookDao.getInstance().findAll();
		
		for (BookVo vo : bookList) {
			System.out.println(vo.toString());
		}
		
		
		System.out.println("=======================카트=======================");
		List<CartVo> cartList = CartDao.getInstance().findAll();
		
		for (CartVo vo : cartList) {
			System.out.println(vo.toString());
		}
		
		System.out.println("=======================주문=======================");
		List<OrderVo> orderList = OrderDao.getInstance().findAll();
		
		for (OrderVo vo : orderList) {
			System.out.println(vo.toString());
		}
		
		
		System.out.println("=======================주문도서=======================");
		List<OrderBookVo> orderBookList = OrderBookDao.getInstance().findAll();
		
		for (OrderBookVo vo : orderBookList) {
			System.out.println(vo.toString());
		}
	}
}
