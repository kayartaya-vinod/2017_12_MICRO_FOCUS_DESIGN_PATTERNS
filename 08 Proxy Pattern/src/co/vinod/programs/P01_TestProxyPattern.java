package co.vinod.programs;

import java.util.Map;

import co.vinod.dao.DaoFactory;
import co.vinod.dao.ProductDao;

public class P01_TestProxyPattern {

	public static void main(String[] args) {
		
		ProductDao dao = DaoFactory.getProductDao();
		System.out.println("dao is an instanceof " + dao.getClass());
		
		dao.deleteProduct(12);
		
		Map<String, Object> map = dao.getProductData(10);
		System.out.println("Searched data is " + map);
		
	}
}
