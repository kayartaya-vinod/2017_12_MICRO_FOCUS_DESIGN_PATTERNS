package co.vinod.example1;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		ProductDao dao = DaoFactory.getProductDao();
		System.out.println("dao is an instanceof " + dao.getClass());
		dao.addProduct("Bamboo pad", 24.6);
		dao.updateProduct();
	}
}

interface ProductDao {
	public void addProduct(Object... params);

	public void updateProduct();
}

class ProductDaoDummyImpl implements ProductDao {

	@Override
	@ResponsibilityChain({ ValidationResponsibility.class, TransactionResponsibility.class })
	public void addProduct(Object... params) {
		System.out.println("Adding a product with values: " + Arrays.toString(params));
	}

	@ResponsibilityChain(ValidationResponsibility.class)
	@Override
	public void updateProduct() {
		System.out.println("Updating the product...");
	}

}

final class DaoFactory {
	private DaoFactory() {
	}

	public static ProductDao getProductDao() {
		return (ProductDao) Proxy.newProxyInstance(DaoFactory.class.getClassLoader(), new Class[] { ProductDao.class },
				new Chain(new ProductDaoDummyImpl()));
	}
}

class Chain implements InvocationHandler {

	Object target = null;

	public Chain(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Method m = target.getClass().getMethod(method.getName(), method.getParameterTypes());

		Annotation[] anns = m.getDeclaredAnnotations();
		for (Annotation an : anns) {
			if (an.annotationType() == ResponsibilityChain.class) {
				ResponsibilityChain rc = (ResponsibilityChain) an;
				for (Class<Responsibility> cls : rc.value()) {
					cls.newInstance().doStuff(args);
				}
			}
		}

		return method.invoke(target, args);
	}

}

interface Responsibility {
	// process the parameters that are intended to the target object's method
	public void doStuff(Object[] params);
}

class ValidationResponsibility implements Responsibility {

	@Override
	public void doStuff(Object[] params) {
		System.out.println("Doing validation on :" + Arrays.toString(params));
	}

}

class TransactionResponsibility implements Responsibility {

	@Override
	public void doStuff(Object[] params) {
		System.out.println("Doing transaction on :" + Arrays.toString(params));
	}

}

@Retention(RUNTIME)
@Target(METHOD)
@interface ResponsibilityChain {
	Class[] value();
}
