package co.vinod.example1;

public class Main {
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl();
		Television tv = new Television();
		AirConditioner ac = new AirConditioner();
		
		rc.setReceiver(tv);
		rc.switchOn();
		rc.switchOff();
		
		rc.setReceiver(ac);
		rc.switchOn();
		rc.switchOff();
	}
}

// invoker
class RemoteControl {
	private Command onCmd, offCmd;
	
	public void setReceiver(Receiver receiver) {
		onCmd = new SwitchOnComamnd(receiver);
		offCmd = new SwitchOffComamnd(receiver);
	}
	public void switchOn() {
		onCmd.execute();
	}
	public void switchOff() {
		offCmd.execute();
	}
	
}

interface Receiver {
	public void switchOn();
	public void switchOff();
}

class Television implements Receiver {

	@Override
	public void switchOn() {
		System.out.println("TV is switched on!");
	}

	@Override
	public void switchOff() {
		System.out.println("TV is switched off!");
	}
	
}

class AirConditioner implements Receiver {

	@Override
	public void switchOn() {
		System.out.println("AirConditioner is switched on!");
	}

	@Override
	public void switchOff() {
		System.out.println("AirConditioner is switched off!");
	}
	
}
interface Command {
	public void execute();
}
class SwitchOnComamnd implements Command {
	// will operate on receiver (target of the command execution)
	private Receiver receiver;
	
	public SwitchOnComamnd(Receiver receiver){
		this.receiver = receiver;
	}
	@Override
	public void execute() {
		receiver.switchOn();
	}
}

class SwitchOffComamnd implements Command {
	// will operate on receiver (target of the command execution)
	private Receiver receiver;
	
	public SwitchOffComamnd(Receiver receiver){
		this.receiver = receiver;
	}
	@Override
	public void execute() {
		receiver.switchOff();
	}
}