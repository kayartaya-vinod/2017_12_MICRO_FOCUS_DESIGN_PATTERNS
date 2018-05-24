package co.vinod.dao;

import java.lang.reflect.Proxy;

public final class DaoFactory {

	private DaoFactory() {
	}
	
	public static ProductDao getProductDao() {
		return (ProductDao) Proxy.newProxyInstance(
				DaoFactory.class.getClassLoader(), 
				new Class[]{ProductDao.class}, 
				new ProductDaoProxy(new ProductDaoDummyImpl()));
		
	}
}
