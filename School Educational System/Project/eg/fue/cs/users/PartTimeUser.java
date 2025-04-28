package eg.fue.cs.users;

import eg.fue.cs.jobs.Job;
import eg.fue.cs.messages.Message;

public class PartTimeUser extends User 
{
    
    // Default constructor
    public PartTimeUser() 
    {
        super(null, 0, null, null);
    }

    // Parameterized constructor
    public PartTimeUser(String name, int age, String address, Job job) 
    {
        super(name, age, address, job);
    }

    @Override
    public boolean sendMsg(User recipient, Message msg) 
    {
        if (recipient instanceof FullTimeUser) 
        {
            recipient.receiveMsg(msg);
            return true; // Can always send messages to FullTimeUsers
        }

        // Ensure both users have a job before checking faculty and department
        Job thisJob = this.getJob();
        Job recipientJob = recipient.getJob();
        
        if (recipient instanceof PartTimeUser && thisJob != null && recipientJob != null) 
        {
            String thisFaculty = thisJob.getFaculty();
            String recipientFaculty = recipientJob.getFaculty();
            String thisDepartment = thisJob.getDepartment();
            String recipientDepartment = recipientJob.getDepartment();

            // Ensure faculty and department are not null before comparing
            if (thisFaculty != null && recipientFaculty != null && thisDepartment != null && recipientDepartment != null) 
            {
                if (thisFaculty.equals(recipientFaculty) && thisDepartment.equals(recipientDepartment)) 
                {
                    recipient.receiveMsg(msg);
                    return true;
                }
            }
        }
        return false;
    }
}
