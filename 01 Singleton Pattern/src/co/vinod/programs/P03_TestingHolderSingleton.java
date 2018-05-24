package co.vinod.programs;

import co.vinod.service.EmployeeService;

public class P03_TestingHolderSingleton {
	public static void main(String[] args) throws Exception{
		
		EmployeeService s1 = EmployeeService.getInstance();
		EmployeeService s2 = EmployeeService.getInstance();
		EmployeeService s3 = EmployeeService.getInstance();
		
		System.out.println("s1 == s2 is " + (s1 == s2));
		System.out.println("s2 == s3 is " + (s2 == s3));
		
		EmployeeService s4 = s1.clone();
		System.out.println("s1 == s4 is " + (s1 == s4));

	}
}
