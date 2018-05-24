package co.vinod.dao;

import java.util.Map;

public interface ProductDao {
	
	public Map<String, Object> getProductData(int id);
	
	public void deleteProduct(int id);
}
