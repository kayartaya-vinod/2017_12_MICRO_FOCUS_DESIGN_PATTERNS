package co.vinod.dao;

public class JpaDaoFactory extends DaoFactory {

	@Override
	public ProductDao getProductDao() {
		return new ProductDaoJpaImpl();
	}

	@Override
	public CustomerDao getCustomerDao() {
		return new CustomerDaoJpaImpl();
	}

	@Override
	public EmployeeDao getEmployeeDao() {
		return new EmployeeDaoJpaImpl();
	}

}
