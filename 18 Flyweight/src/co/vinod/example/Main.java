package co.vinod.example;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		long f = new FactorialFactory().factorial(10);
		System.out.println("f=" + f);
	}
}

class FactorialFactory {

	// cache
	long[] cache = new long[12];
	int index = -1;

	public long factorial(int n) {
		if (n <= 0)
			return 1;

		if (n <= index) {
			return cache[n];
		}
		long f = n * factorial(n - 1);
		cache[++index] = f;
		System.out.println(Arrays.toString(cache));
		
		return f;
	}
}
