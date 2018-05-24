package co.vinod.programs;

import co.vinod.pattenrs.SqlBuilder;

public class P01_TestSqlBuilder {
	public static void main(String[] args) {
		
		SqlBuilder sb = new SqlBuilder();
		String sql = sb.from("customers")
			.join("orders", "orders.customer_id=customers.id")
			.where("email like ?", "%gmail%")
			.whereOr("state like ?", "%Karnataka%")
			.order("city", "asc")
			.order("name", "asc")
			.build();
		
		
		System.out.println(sql);
		System.out.println(sb.values());
		
	}
}
