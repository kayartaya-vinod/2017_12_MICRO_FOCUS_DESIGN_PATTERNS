package co.vinod.programs;

import co.vinod.dao.CustomerDao;
import co.vinod.dao.DaoFactory;
import co.vinod.dao.EmployeeDao;
import co.vinod.dao.ProductDao;

public class P01_TestAbstractFactoryClassPattern {
	public static void main(String[] args) throws Exception {
		
		DaoFactory factory = DaoFactory.getInstance();
		System.out.println("factory is of type: " + factory.getClass());
		
		EmployeeDao edao = factory.getEmployeeDao();
		ProductDao pdao = factory.getProductDao();
		CustomerDao cdao = factory.getCustomerDao();
		
		System.out.println("edao --> " + edao.getClass());
		System.out.println("pdao --> " + pdao.getClass());
		System.out.println("cdao --> " + cdao.getClass());
		
		
	}
}
