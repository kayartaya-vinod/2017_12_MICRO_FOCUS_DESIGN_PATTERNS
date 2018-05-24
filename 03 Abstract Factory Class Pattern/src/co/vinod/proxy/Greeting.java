package co.vinod.proxy;

import java.lang.reflect.Proxy;

public class Greeting implements IGreeting {
	public void greet() {
		System.out.println("Hi there!");
	}

	public void sayHello(String name) {
		System.out.println("Hello, " + name + "!");
	}

	public static void main(String[] args) {

		IGreeting gr = (IGreeting) Proxy.newProxyInstance(Greeting.class.getClassLoader(),
				new Class[] { IGreeting.class }, new TimerProxy(new Greeting()));

		System.out.println("gr is an instanceof " + gr.getClass());
		gr.sayHello("Vinod");
		gr.greet();
		
		System.out.println(gr);

	}

	@Override
	public String toString() {
		return "This is the greeting class";
	}
	
	
}
