package eg.fue.cs.users;

import eg.fue.cs.jobs.Job;
import eg.fue.cs.messages.Message;

public class FullTimeUser extends User {
    
    // Default constructor
    public FullTimeUser() 
    {
        super(null, 0, null, null);
    }

    // Parameterized constructor
    public FullTimeUser(String name, int age, String address, Job job) 
    {
        super(name, age, address, job);
    }

    @Override
    public boolean sendMsg(User recipient, Message msg)
     {
        if (recipient != null) {
            recipient.receiveMsg(msg);
            return true;
        }
        return false;
    }
}
