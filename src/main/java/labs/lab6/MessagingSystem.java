package labs.lab6;

import java.util.ArrayList;
import java.util.Hashtable;
/**
 * An email messaging system.
 */
public class MessagingSystem {
	// ADD YOUR INSTANCE VARIABLES HERE
	private Hashtable<String, ArrayList<Message>> userMessages;
	/**
	 * Constructs a MessagingSystem object
	 */
	public MessagingSystem() {
		userMessages = new Hashtable<>();
	}


	/**
	 * Delivers a message to the recipient
	 * 
	 * @param sender		message sender
	 * @param recipient		message recipient
	 * @param text			text of the message
	 */
	public void deliver(String sender, String recipient, String text) {
		
		if (!userMessages.containsKey(recipient)){ 
			ArrayList<Message> newMessage =  new ArrayList<Message>();
			newMessage.add(new Message(sender, recipient, text));
			userMessages.put(recipient, newMessage);		
		} else {
			userMessages.get(recipient).add(new Message(sender, recipient, text));
		}

	}

	
	/**
	 * Retrieves the messages for a user
	 * 
	 * @param user the user
	 */
	public String getMessages(String user) {
		String messageString = "";
		for (Message message : userMessages.get(user)) {
			messageString += " -----\n";
			messageString += message.toString();
		}
		return messageString; // FIX ME
	}
}
