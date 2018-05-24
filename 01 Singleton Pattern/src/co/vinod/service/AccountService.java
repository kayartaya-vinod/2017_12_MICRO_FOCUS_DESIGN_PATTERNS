package co.vinod.service;

import java.io.Serializable;

public class AccountService implements Serializable{

	private static final long serialVersionUID = 1L;
	private static AccountService instance; // = new AccountService(); // eager instantiation

	private AccountService() {
		System.out.println("AccountService instantiated!");
		if(instance!=null){
			throw new RuntimeException("Not allowed!");
		}
	}

	public static AccountService getInstance() {
		
		if (instance == null) {
			// lazy instantiation
			synchronized(AccountService.class){
				if(instance==null){
					instance = new AccountService();
				}
			}
		}
		return instance;
	}
	
	// needed while deserialization
	public Object readResolve(){
		return instance;
	}

	// service related operations
}









