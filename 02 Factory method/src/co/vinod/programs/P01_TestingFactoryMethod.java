package co.vinod.programs;

import co.vinod.dao.ProductDao;
import co.vinod.dao.ProductDaoFactory;

public class P01_TestingFactoryMethod {
	public static void main(String[] args) throws Exception {
		
		ProductDao dao;
		
		dao = ProductDaoFactory.getInstance();
		dao.addProduct();
		dao.updateProduct();
		
	}
}
