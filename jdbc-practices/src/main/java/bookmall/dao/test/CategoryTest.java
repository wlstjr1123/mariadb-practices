package bookmall.dao.test;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryTest {
	
	public static void main(String[] args) {
		insertTest();
//		findAllTest();
	}
	
	public static void insertTest() {
		CategoryVo categoryVo1 = new CategoryVo();
		categoryVo1.setCategory("소설");
		
		CategoryVo categoryVo2 = new CategoryVo();
		categoryVo2.setCategory("컴퓨터");
		
		CategoryVo categoryVo3 = new CategoryVo();
		categoryVo3.setCategory("경제");
		
		CategoryDao.getInstance().insert(categoryVo1);
		CategoryDao.getInstance().insert(categoryVo2);
		CategoryDao.getInstance().insert(categoryVo3);
	}
}