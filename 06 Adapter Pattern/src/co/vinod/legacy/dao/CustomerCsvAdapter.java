package co.vinod.legacy.dao;

public class CustomerCsvAdapter implements CustomerDao {

	// reference to the actual dao
	CustomerCsvDao dao;
	
	public CustomerCsvAdapter() {
		dao = new CustomerCsvDao();
	}
	
	@Override
	public void addCustomer(Object... args) {
		// convert args to CSV string
		System.out.println("converting args to CSV string...");
		String csv = "..."; // customer object in CSV format
		dao.addRow(csv);
	}

	@Override
	public void updateCustomer(Object... args) {
		System.out.println("converting args to CSV string...");
		String csv = "..."; // customer object in CSV format
		dao.replace(csv, 1);
	}

}
