package eg.fue.cs.messages;

import eg.fue.cs.users.User;

public class PrivateMessage extends Message {
    
    // Default constructor
    public PrivateMessage() {
        super();
    }

    // Parameterized constructor
    public PrivateMessage(String subject, String body, User from, User to) {
        super(subject, body, from, to);
    }

    @Override
    public boolean canSend() {
        if (getFrom() == null || getTo() == null) return false;
        return getFrom().getClass().equals(getTo().getClass()); // Users must be of the same type
    }
}
