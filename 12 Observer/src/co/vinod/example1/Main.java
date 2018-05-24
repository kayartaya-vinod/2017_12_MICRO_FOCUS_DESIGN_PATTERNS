package co.vinod.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		
		dao.registerAddProductListener(new AddProductListener() {
			public void onProductAdded() {
				System.out.println("LISTENER 1 >>>> new product added.");
			}
		});
		
		
		dao.addProduct();
		dao.addProduct();
		
		dao.registerAddProductListener(new MailSender());
		dao.addProduct();
		dao.addProduct();
	}
}

// subscription interface
interface AddProductListener {
	public void onProductAdded();
}

class MailSender implements AddProductListener {

	@Override
	public void onProductAdded() {
		System.out.println("MAILSENDER::::New product added!");
	}
	
}


// subbject
class ProductDao {
	
	List<AddProductListener> addProductListeners = new ArrayList<>();
	
	public void registerAddProductListener(AddProductListener listener){
		addProductListeners.add(listener);
	}
	private void notifyAllAddProductListeners(){
		for(AddProductListener l: addProductListeners){
			l.onProductAdded();
		}
	}
	
	public void addProduct() {
		System.out.println("Adding a new product....");
		notifyAllAddProductListeners();
	}
	
	public Map<String, Object> getProduct(){
		return null;
	}
}