package co.vinod.programs;

import co.vinod.legacy.dao.CustomerCsvAdapter;
import co.vinod.legacy.dao.CustomerDao;

public class P01_TestAdapterPattern {
	public static void main(String[] args) {
		
		CustomerDao dao = new CustomerCsvAdapter();
		dao.addCustomer();
		
		dao.updateCustomer();
	}
}
