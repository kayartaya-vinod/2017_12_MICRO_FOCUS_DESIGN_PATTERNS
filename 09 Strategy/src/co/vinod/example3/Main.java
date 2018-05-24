package co.vinod.example3;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

public class Main {
	public static void main(String[] args) {
		Customer c1 = new Customer(1, "Vinod", "Bangalore", "vinod@vinod.co");
		System.out.println(c1);
		c1.setFormatStrategy(new FormatCsvStrategy());
		System.out.println(c1);
		c1.setFormatStrategy(new FormatXmlStrategy());
		System.out.println(c1);
		
		Employee e1 = new Employee(8744, "Scott", 3300);
		System.out.println(e1);
		e1.setStrategy(new FormatCsvStrategy());
		System.out.println(e1);
		e1.setStrategy(new FormatXmlStrategy());
		System.out.println(e1);
	}
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Customer {
	private int id;
	private String name;
	private String city;
	private String email;

	@XmlTransient
	private FormatStrategy strategy;
	
	public Customer() {
	}

	public Customer(int id, String name, String city, String email) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setFormatStrategy(FormatStrategy strategy){
		this.strategy = strategy;
	}

	@Override
	public String toString() {
		
		if(strategy!=null) return strategy.format(this);
		
		return "Customer [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + "]";
	}
	

}

interface FormatStrategy {
	String format(Object obj);
}

class FormatCsvStrategy implements FormatStrategy {

	@Override
	public String format(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		
		StringBuffer sb = new StringBuffer();
		
		for(Field f: fields){
			f.setAccessible(true);
			try {
				Object value = f.get(obj);
				if(value==this) continue;
				
				sb.append(value).append(",");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}
	
}

class FormatXmlStrategy implements FormatStrategy {

	@Override
	public String format(Object obj) {
		try {
			JAXBContext ctx = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			marshaller.marshal(obj, baos);
			byte[] bytes = baos.toByteArray();
			return new String(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Employee {
	int id;
	String name;
	double salary;
	
	@XmlTransient
	FormatStrategy strategy;
	
	public Employee() {
	}

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setStrategy(FormatStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public String toString() {
		if(strategy!=null) return strategy.format(this);
		
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}








