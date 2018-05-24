package co.vinod.dao;

import java.util.ResourceBundle;

public final class ProductDaoFactory {
	private ProductDaoFactory() {
	}

	public static ProductDao getInstance() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("co.vinod.dao.dao");
		String implClass = rb.getString("ProductDao.impl");
		return (ProductDao) Class.forName(implClass).newInstance();
	}
}
