package co.vinod.example2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// receivers...
		AsiaServer asiaServer = new AsiaServer();
		USServer usServer = new USServer();
		EuroServer euroServer = new EuroServer();

		ShutdownCommand shutdownAsia = new ShutdownCommand(asiaServer);
		RebootCommand rebootUs = new RebootCommand(usServer);
		
		DiagnosticsCommand diagnoseEuro = new DiagnosticsCommand(euroServer);
		RebootCommand rebootEuro = new RebootCommand(euroServer);
		
		Invoker invoker = new Invoker();
		invoker.addCommand(shutdownAsia);
		invoker.addCommand(rebootUs);
		invoker.addCommand(diagnoseEuro);
		invoker.addCommand(rebootEuro);
		
		invoker.run();
	}

}

interface Receiver {
	public void connect();

	public void disconnect();

	public void reboot();

	public void shutdown();

	public void runDiagnostics();
}

interface Command {
	public void execute();
}

class ShutdownCommand implements Command {
	private Receiver receiver;

	public ShutdownCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// job to be done on a particular server
		receiver.connect();
		receiver.shutdown();
		receiver.disconnect();
	}
}

class RebootCommand implements Command {
	private Receiver receiver;

	public RebootCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// job to be done on a particular server
		receiver.connect();
		receiver.reboot();
		receiver.disconnect();
	}
}

class DiagnosticsCommand implements Command {
	private Receiver receiver;

	public DiagnosticsCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// job to be done on a particular server
		receiver.connect();
		receiver.runDiagnostics();
		receiver.disconnect();
	}
}

class AsiaServer implements Receiver {

	@Override
	public void connect() {
		System.out.println("Connectin to Asia server...");
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnecting from Asia server...");
	}

	@Override
	public void reboot() {
		System.out.println("Rebooting the Asia server...");
	}

	@Override
	public void shutdown() {
		System.out.println("Shutting down the Asia server...");
	}

	@Override
	public void runDiagnostics() {
		System.out.println("Running the diagnostic plan on Asia server...");
	}

}

class EuroServer implements Receiver {

	@Override
	public void connect() {
		System.out.println("Connectin to Euro server...");
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnecting from Euro server...");
	}

	@Override
	public void reboot() {
		System.out.println("Rebooting the Euro server...");
	}

	@Override
	public void shutdown() {
		System.out.println("Shutting down the Euro server...");
	}

	@Override
	public void runDiagnostics() {
		System.out.println("Running the diagnostic plan on Euro server...");
	}

}

class USServer implements Receiver {

	@Override
	public void connect() {
		System.out.println("Connectin to US server...");
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnecting from US server...");
	}

	@Override
	public void reboot() {
		System.out.println("Rebooting the US server...");
	}

	@Override
	public void shutdown() {
		System.out.println("Shutting down the US server...");
	}

	@Override
	public void runDiagnostics() {
		System.out.println("Running the diagnostic plan on US server...");
	}

}

class Invoker {
	// private Command command;

	private List<Command> commands;

	public Invoker() {
		commands = new ArrayList<Command>();
	}

	// public void setCommand(Command command) {
	// this.command = command;
	// }
	public void addCommand(Command command) {
		commands.add(command);
	}

	public void run() {
		for (Command command : commands) {
			command.execute();
			System.out.println();
		}
	}
}
