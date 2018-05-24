package co.vinod.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerProxy implements InvocationHandler {

	private Object target;

	public TimerProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start = System.nanoTime();
		Object result = method.invoke(target, args);
		long elapsed = System.nanoTime() - start;

		System.out.printf("Executing %s finished in %s ns\n", method.getName(), elapsed);

		return result;
	}

}
