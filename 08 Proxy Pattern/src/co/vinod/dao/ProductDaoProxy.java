package co.vinod.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProductDaoProxy implements InvocationHandler {
	Object target;

	public ProductDaoProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object retVal = null;
		switch (method.getName()) {
		case "deleteProduct":
		case "addProduct":
		case "updateProduct":
			System.out.printf("Beginning the transaction for method {%s}...\n", method.getName());
			retVal = method.invoke(target, args);
			System.out.printf("Committing the transaction for method {%s}...\n", method.getName());

			break;
		default:
			retVal = method.invoke(target, args);
		}

		return retVal;
	}
}
