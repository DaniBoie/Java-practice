package labs.lab6;
import java.util.ArrayList;


/**
 * An email mailbox.
 */
public class Mailbox {
	// ADD YOUR INSTANCE VARIABLES HERE
	private String user;
	private ArrayList<Message> messages;
	/**
	 * Constructs a Mailbox object.
	 * 
	 * @param user the user
	 */
	public Mailbox(String user) {
		messages = new ArrayList<Message>();
		this.user = user;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user of this mailbox
	 */
	public String getUser() {
		return user; // FIX ME
	}

	/**
	 * Adds a message to the mailbox.
	 * 
	 * @param m the message to add
	 */
	public void addMessage(Message m) {
		// FILL IN
		messages.add(m);
	}

	/**
	 * Retrieves text of all messages, in the following format:
	 * -----
	 * [MESSAGE1]
	 * -----
	 * [MESSAGE2]
	 * 
	 * etc.
	 */
	public String getAllMessages() {
		String messageString = "";
		for (Message message : messages) {
			messageString += " -----\n";
			messageString += message.toString();

		}
		return messageString;
	}
}
