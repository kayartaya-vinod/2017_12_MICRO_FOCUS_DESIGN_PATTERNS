package co.vinod.programs;

import co.vinod.patterns.Directory;
import co.vinod.patterns.File;

public class P01_TestingComposite {
	public static void main(String[] args) {
		
		Directory root = new Directory("Vinod");
		root.addContent(new File("Shyam"));
		root.addContent(new File("Sathya"));
		
		Directory dir1 = new Directory("Vikram");
		root.addContent(dir1);
		

		
		Directory dir2 = new Directory("Naveen");

		dir1.addContent(new File("Subhash"));
		dir1.addContent(new File("Ramesh"));
		dir1.addContent(dir2);
		
		
		root.print();
		
		
		
	}
}
