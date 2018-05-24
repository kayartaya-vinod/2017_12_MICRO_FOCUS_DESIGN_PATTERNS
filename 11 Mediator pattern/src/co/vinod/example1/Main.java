package co.vinod.example1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		ChatRoom room = new ChatRoom();
		User user1 = new User("Vinod", room);
		User user2 = new User("Shyam", room);
		
		user1.writeMessage("Hello!");
		user2.writeMessage("Hi");
		user1.writeMessage("How are you?");
		user1.writeMessage("Long time no C");
		user2.writeMessage("Yeas, I was busy!");
		
		User user3 = new User("John", room);
		user3.writeMessage("Hey guys!");
		
		user1.printMessages();
	}
}

// colleague
class User {
	String name;
	ChatRoom room;

	public User(String name, ChatRoom room) {
		this.name = name;
		this.room = room;
	}

	public void writeMessage(String message) {
		room.postMessage(message, this);
	}

	public void printMessages() {
		for (String message : room.readMessages()) {
			System.out.println(message);
		}
	}

}

// mediator
class ChatRoom {
	List<String> messages = new ArrayList<>();

	public void postMessage(String message, User user) {
		messages.add(String.format("%s : %s", user.name, message));
	}

	public List<String> readMessages() {
		return messages;
	}
}