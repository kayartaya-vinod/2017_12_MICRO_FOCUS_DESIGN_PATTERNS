package co.vinod.legacy.dao;

public class CustomerCsvDao {
	public void addRow(String csv){
		System.out.println("Aadding CSV data to the Excel file...");
	}
	public void replace(String csv, int line){
		System.out.println("Updating CSV data to the Excel file...");
	}
	public String getCsv(int line){
		System.out.println("CSV at line specified...");
		return "dummy CSV";
	}
}
