package co.vinod.dao;

public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public void addProduct(Object... args) {
		System.out.println("Adding product to a db table...");
	}

	@Override
	public void updateProduct(Object... args) {
		System.out.println("Updating product in a db table...");
	}

}
