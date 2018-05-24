package co.vinod.dao;

import java.util.ResourceBundle;

public abstract class DaoFactory {

	static class Holder {
		static DaoFactory instance = null;
		static {
			ResourceBundle rb = ResourceBundle.getBundle("co.vinod.dao.dao");
			String implClass = rb.getString("dao.factory.impl");
			try {
				instance = (DaoFactory) Class.forName(implClass).newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static DaoFactory getInstance() throws Exception {
		return Holder.instance;
	}

	public abstract ProductDao getProductDao();

	public abstract CustomerDao getCustomerDao();

	public abstract EmployeeDao getEmployeeDao();
}
