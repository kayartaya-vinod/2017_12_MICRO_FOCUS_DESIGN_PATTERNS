package co.vinod.example2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Vinod", "Anupama Salunke S", "John Doe", "Karishma", "Michael Jordan",
				"Vinod Kumar Kayartaya");
		
		// sort by length of names
		Collections.sort(names, (s1, s2) -> s1.length() - s2.length());

		printNames(names);
	}

	private static void printNames(List<String> names) {
		for (String name : names) {
			System.out.println(name);
		}
	}

}
