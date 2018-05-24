package co.vinod.service;

public class EmployeeService implements Cloneable{
	
	private EmployeeService() {
	}

	static class Holder {
		private static EmployeeService instance = new EmployeeService();
	}

	public static EmployeeService getInstance() {
		return Holder.instance;
	}
	
	@Override
	public EmployeeService clone() throws CloneNotSupportedException {
		return getInstance();
	}

	// other service operations here..

}
