package co.vinod.dao;

import java.util.HashMap;
import java.util.Map;

public class ProductDaoDummyImpl implements ProductDao {

	@Override
	public void deleteProduct(int id) {
		System.out.println("Deleting product with id: " + id);
	}

	@Override
	public Map<String, Object> getProductData(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", "Test product");
		return map;
	}

}
