package co.vinod.example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BrandDao dao = new BrandDao();
		Brand b1 = dao.getById(2);

		System.out.println(b1);
		
		ProductDao dao1 = new ProductDao();
		System.out.println(dao1.get(10));
		
		for(Brand b: dao.getAllBrands()){
			System.out.println(b);
		}
		System.out.println("--------------------------");
		for(Product p: dao1.getByPriceRange(10.0, 15.0)){
			System.out.println(p);
		}
	}
}

class Brand {
	int id;
	String name;

	public Brand() {
	}

	public Brand(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + "]";
	}

}


abstract class DaoTemplate<T> {
	
	abstract public T fromResultSet(ResultSet rs) throws Exception;

	private Connection createConnection() throws Exception {
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/microfocusdb", "sa", "");
	}

	protected T getOne(String sql, Object... params) throws Exception {
		Connection conn = createConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);

		for (int i = 0; i < params.length; i++) {
			stmt.setObject(i + 1, params[i]);
		}

		ResultSet rs = stmt.executeQuery();

		try {
			if (rs.next()) {
				return fromResultSet(rs);
			} else {
				return null;
			}
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}

	}

	protected List<T> getMany(String sql, Object... params) throws Exception {
		Connection conn = createConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);

		for (int i = 0; i < params.length; i++) {
			stmt.setObject(i + 1, params[i]);
		}

		ResultSet rs = stmt.executeQuery();
		List<T> list = new ArrayList<>();
		try {
			while (rs.next()) {
				list.add(fromResultSet(rs));
			} 
			return list;
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	}
}

class BrandDao extends DaoTemplate<Brand> {
	
	@Override
	public Brand fromResultSet(ResultSet rs) throws Exception {
		Brand b = new Brand();
		b.setId(rs.getInt(1));
		b.setName(rs.getString(2));
		return b;
	}

	public Brand getById(int id) throws Exception {
		return getOne("select * from brands where id = ?", id);
	}
	
	public List<Brand> getAllBrands() throws Exception{
		return super.getMany("select * from brands");
	}
}

class Product {
	int id;
	String name;
	double price;
	double discount;
	String description;
	
	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", discount=" + discount + ", description="
				+ description + "]";
	}
	
}


class ProductDao extends DaoTemplate<Product> {

	@Override
	public Product fromResultSet(ResultSet rs) throws Exception {
		Product p = new Product();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setDescription(rs.getString("description"));
		p.setPrice(rs.getDouble("unit_price"));
		p.setDiscount(rs.getDouble("discount"));
		return p;
	}
	
	public Product get(int id) throws Exception {
		return super.getOne("select * from products where id = ?", id);
	}
	
	public List<Product> getAllProducts() throws Exception {
		return super.getMany("select * from products");
	}
	
	public List<Product> getByPriceRange(double min, double max) throws Exception {
		return super.getMany("select * from products where unit_price between ? and ? order by unit_price", min, max);
	}
	
}
















