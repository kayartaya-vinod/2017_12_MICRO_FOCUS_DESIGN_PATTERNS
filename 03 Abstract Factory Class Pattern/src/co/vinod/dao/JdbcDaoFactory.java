package co.vinod.dao;

public class JdbcDaoFactory extends DaoFactory {

	@Override
	public ProductDao getProductDao() {
		return new ProductDaoJdbcImpl();
	}

	@Override
	public CustomerDao getCustomerDao() {
		return new CustomerDaoJdbcImpl();
	}

	@Override
	public EmployeeDao getEmployeeDao() {
		return new EmployeeDaoJdbcImpl();
	}

}
