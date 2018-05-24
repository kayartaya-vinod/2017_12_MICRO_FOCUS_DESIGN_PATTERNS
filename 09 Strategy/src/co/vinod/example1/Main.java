package co.vinod.example1;

public class Main {
	public static void main(String[] args) {
		Vehicle viking = new Vehicle();
		viking.go();
		viking.go();
		viking.setGoStrategy(new FlyStrategy());
		viking.go();
		viking.setGoStrategy(new RunStrategy());
		viking.go();
		viking.setGoStrategy(new WalkStrategy());
		viking.go();
	}
}

class Vehicle {
	private GoStrategy strategy;

	public Vehicle() {
		strategy = new WalkStrategy();
	}

	public void setGoStrategy(GoStrategy strategy) {
		this.strategy = strategy;
	}

	public void go() {
		strategy.go();
	}
}

interface GoStrategy {
	public void go();
}

class FlyStrategy implements GoStrategy {

	@Override
	public void go() {
		System.out.println("Now I am flying...");
	}

}

class WalkStrategy implements GoStrategy {

	@Override
	public void go() {
		System.out.println("Now I am walking...");
	}

}

class RunStrategy implements GoStrategy {

	@Override
	public void go() {
		System.out.println("Now I am running...");
	}

}