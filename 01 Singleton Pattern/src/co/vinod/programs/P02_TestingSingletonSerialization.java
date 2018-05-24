package co.vinod.programs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.vinod.service.AccountService;

public class P02_TestingSingletonSerialization {
	public static void main(String[] args) throws Exception {

		AccountService s1 = AccountService.getInstance();

		FileOutputStream file = new FileOutputStream("test");
		ObjectOutputStream out = new ObjectOutputStream(file);

		out.writeObject(s1);
		out.close();
		file.close();

		System.out.println("AccountService instance serialized...");

		FileInputStream file1 = new FileInputStream("test");
		ObjectInputStream in = new ObjectInputStream(file1);
		AccountService s2 = (AccountService) in.readObject();
		in.close();
		file1.close();
		
		file1 = new FileInputStream("test");
		in = new ObjectInputStream(file1);
		AccountService s3 = (AccountService) in.readObject();
		in.close();
		
		System.out.println("s1 == s2 is " + (s1 == s2));
		System.out.println("s2 == s3 is " + (s2 == s3));

	}
}
