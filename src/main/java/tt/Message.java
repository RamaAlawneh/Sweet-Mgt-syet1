package tt;

import java.time.LocalDateTime; // Import the LocalDateTime class for handling timestamps

public class Message {
    private String messageId;
    private String senderEmail;
    private String recipientEmail;
    private String messageContent;
    private LocalDateTime timestamp; // Field to store the timestamp of the message
    private String originalMessageId; // Field to link replies to their original message

    // Constructor
    public Message(String messageId, String senderEmail, String recipientEmail, String messageContent) {
        this.messageId = messageId;
        this.senderEmail = senderEmail;
        this.recipientEmail = recipientEmail;
        this.messageContent = messageContent;
        this.timestamp = LocalDateTime.now(); // Initialize timestamp when message is created
        this.originalMessageId = null; // Default to null for new messages
    }

    // Additional constructor to handle replies with an original message ID
    public Message(String messageId, String senderEmail, String recipientEmail, String messageContent, String originalMessageId) {
        this(messageId, senderEmail, recipientEmail, messageContent);
        this.originalMessageId = originalMessageId;
    }

    // Getters
    public String getMessageId() {
        return messageId;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getOriginalMessageId() {
        return originalMessageId;
    }

    // Setter for originalMessageId
    public void setOriginalMessageId(String originalMessageId) {
        this.originalMessageId = originalMessageId;
    }
}
