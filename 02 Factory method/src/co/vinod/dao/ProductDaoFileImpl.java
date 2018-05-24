package co.vinod.dao;

public class ProductDaoFileImpl implements ProductDao {

	@Override
	public void addProduct(Object... args) {
		System.out.println("Adding product to a file...");
	}

	@Override
	public void updateProduct(Object... args) {
		System.out.println("Updating product in a file...");
	}

}
