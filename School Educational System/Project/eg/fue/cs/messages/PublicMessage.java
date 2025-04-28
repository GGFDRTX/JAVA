package eg.fue.cs.messages;

import eg.fue.cs.users.User;

public class PublicMessage extends Message {
    
    // Default constructor
    public PublicMessage() {
        super(null, null, null, null);
    }

    // Parameterized constructor
    public PublicMessage(String subject, String body, User from, User to) {
        super(subject, body, from, to);
    }

    @Override
    public boolean canSend() {
        return true; // Public messages are always allowed
    }
}
