package co.vinod.patterns;

import java.util.ArrayList;
import java.util.List;

public class Directory implements IFile {
	public static int INDENT = 0;
	
	private String name;
	
	private List<IFile> contents = new ArrayList<>();
	
	public Directory(String name) {
		this.name = name;
	}
	
	public void addContent(IFile content){
		contents.add(content);
	}
	
	@Override
	public void print() {
		for(int i=0; i<INDENT; i++){
			System.out.print(" ");
		}
		System.out.print("Directory: " + name + "\n");
		INDENT+=4;
		
		for(IFile file: contents){
			file.print();
		}
		
		INDENT-=4;

	}

}
