package co.vinod.programs;

import java.lang.reflect.Constructor;

import co.vinod.service.AccountService;

public class P01_TestSingleton {

	public static void main(String[] args) throws Exception {
		AccountService s1 = AccountService.getInstance();
		AccountService s2 = AccountService.getInstance();
		AccountService s3 = AccountService.getInstance();

		System.out.println("s1 == s2 is " + (s1 == s2));
		System.out.println("s2 == s3 is " + (s2 == s3));
		
		Constructor<AccountService> constr = 
				AccountService.class.getDeclaredConstructor();
		constr.setAccessible(true);
		AccountService s4 = constr.newInstance();
		constr.setAccessible(false);
		System.out.println("s2 == s4 is " + (s2 == s4));
		
		
	}
}
