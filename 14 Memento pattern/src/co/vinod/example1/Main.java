package co.vinod.example1;

import java.util.Date;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Product p1 = new Product(1, "Mobile phone", 34000);
		
		// instead of using a data structure here, Caretaker must a class
		// that has appropriate methods to store and retrieve state
		
		Stack<Memento> caretaker = new Stack<>();
		caretaker.push(p1.createMemento());
		p1.setPrice(p1.getPrice()+200);
		caretaker.push(p1.createMemento());
		p1.setName("Samsung Galaxy s6");
		caretaker.push(p1.createMemento());
		p1.setPrice(45000);
		caretaker.push(p1.createMemento());
		System.out.println(p1);
		
		p1.restorFromMemento(caretaker.pop());
		System.out.println(p1);
		p1.restorFromMemento(caretaker.pop());
		System.out.println(p1);
		p1.restorFromMemento(caretaker.pop());
		System.out.println(p1);
		p1.restorFromMemento(caretaker.pop());
		System.out.println(p1);
		p1.restorFromMemento(caretaker.pop());
		System.out.println(p1);
	}
}


class Memento {
	private Object state;
	private Date creationDatetime = new Date();
	
	public Memento(Object state) {
		this.state = state;
	}
	public Object getState() {
		return state;
	}
	
	public Date getCreationDatetime() {
		return creationDatetime;
	}
}

interface Originator {
	public Memento createMemento();
	public void restorFromMemento(Memento memento);
}

// Originator
class Product implements Originator {
	int id;
	String name;
	double price;
	
	public Product() {
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	// convert the object's state as a memento
	@Override
	public Memento createMemento() {
		Product p = new Product(this.id, this.name, this.price);
		return new Memento(p);
	}

	@Override
	public void restorFromMemento(Memento memento) {
		Product p = (Product) memento.getState();
		this.id = p.id;
		this.name = p.name;
		this.price = p.price;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	
}