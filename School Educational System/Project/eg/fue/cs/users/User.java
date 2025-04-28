package eg.fue.cs.users;

import java.util.ArrayList;
import java.util.List;

import eg.fue.cs.jobs.Job;
import eg.fue.cs.messages.Message;

public class User {
    private String name;
    private int age;
    private String address;
    private Job job;
    private final List<Message> inbox = new ArrayList<>();
    private final List<Message> sent = new ArrayList<>();

    public User(String name, int age, String address, Job job) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }

    public List<Message> getInbox() { return new ArrayList<>(inbox); }
    public List<Message> getSent() { return new ArrayList<>(sent); }

    // Methods
    public void changeJob(Job job) { this.job = job; }

    public void receiveMsg(Message msg) {
        if (msg != null) {
            inbox.add(msg);
        }

        
    }
    public boolean canSendMessageTo(User recipient) {
        return this.sendMsg(recipient, new Message()); // Uses sendMsg() logic
    }
    

    public boolean sendMsg(User recipient, Message msg) {
        if (recipient != null && msg != null && msg.canSend()) {
            recipient.receiveMsg(msg);
            sent.add(msg);
            return true;
        }
        return false;
    }

    public boolean deleteMsg(Message msg) {
        return inbox.remove(msg);
    }
}
