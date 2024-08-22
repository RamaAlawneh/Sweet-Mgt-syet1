package tt;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessagingSystem {
    private List<Message> messages;

    public MessagingSystem() {
        this.messages = new ArrayList<>();
    }

    // Method to add a message to the system
    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public static void main(String[] args) {
        MessagingSystem system = new MessagingSystem();

        // Create and add messages
        system.addMessage(new Message(
                UUID.randomUUID().toString(),
                "user1@example.com",
                "user2@example.com",
                "Hello User2, how are you doing today?"
        ));

        system.addMessage(new Message(
                UUID.randomUUID().toString(),
                "user2@example.com",
                "user3@example.com",
                "Hi User3, did you receive the documents?"
        ));

        system.addMessage(new Message(
                UUID.randomUUID().toString(),
                "user3@example.com",
                "user1@example.com",
                "User1, I'll send you the details by tomorrow."
        ));

        // Output to demonstrate that messages are added
        for (Message m : system.messages) {
            System.out.println("Message from " + m.getSenderEmail() + " to " + m.getRecipientEmail() + ": " + m.getMessageContent());
        }
    }
}
