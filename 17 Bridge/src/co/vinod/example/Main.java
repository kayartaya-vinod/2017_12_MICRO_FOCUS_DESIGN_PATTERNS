package co.vinod.example;

public class Main {
	public static void main(String[] args) {
		Television tv = new Television();
		RemoteControl rc = new TvRemote(tv);
		
		rc.switchOn();
		rc.switchOff();
	}
}

abstract class Device {
	abstract void on();
	abstract void off();
}

abstract class RemoteControl {
	protected Device device;
	
	public RemoteControl(Device device) {
		this.device = device;
	}
	
	abstract void switchOn();
	abstract void switchOff();
}

class TvRemote extends RemoteControl {
	
	

	public TvRemote(Device device) {
		super(device);
	}

	@Override
	void switchOn() {
		device.on();
	}

	@Override
	void switchOff() {
		device.off();
	}
	
}

class Television extends Device {

	@Override
	void on() {
		System.out.println("TV switched on!");
	}

	@Override
	void off() {
		System.out.println("TV switched off!");		
	}
	
}
