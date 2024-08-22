package tt;

public class Feedback {
    private String feedbackId;
    private String userEmail;
    private String feedbackText;
    private String response;

    // Constructor
    public Feedback(String feedbackId, String userEmail, String feedbackText) {
        this.feedbackId = feedbackId;
        this.userEmail = userEmail;
        this.feedbackText = feedbackText;
        this.response = null;
    }

    // Getters and Setters
    public String getFeedbackId() { return feedbackId; }
    public String getUserEmail() { return userEmail; }
    public String getFeedbackText() { return feedbackText; }
    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }

    @Override
    public String toString() {
        return "Feedback ID: " + feedbackId + "\n" +
                "User: " + userEmail + "\n" +
                "Feedback: " + feedbackText;
    }
}



