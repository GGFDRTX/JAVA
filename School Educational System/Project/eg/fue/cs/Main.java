package eg.fue.cs;

import eg.fue.cs.jobs.Lecturer;
import eg.fue.cs.jobs.Student;
import eg.fue.cs.jobs.TeacherAssistant;
import eg.fue.cs.messages.Message;
import eg.fue.cs.messages.PrivateMessage;
import eg.fue.cs.messages.PublicMessage;
import eg.fue.cs.users.FullTimeUser;
import eg.fue.cs.users.PartTimeUser;
import eg.fue.cs.users.User;

public class Main {
    public static void main(String[] args) {
        // Create jobs
        Student studentJob = new Student("Student", "Student at FUE", "Engineering", "Computer Science", 3);
        TeacherAssistant taJob = new TeacherAssistant("TA", "Teaching Assistant", "Engineering", "Computer Science", 2020);
        Lecturer lecturerJob = new Lecturer("Lecturer", "Lecturer at FUE", "Engineering", "Computer Science", 5);

        // Create users
        FullTimeUser student = new FullTimeUser("John Doe", 20, "Cairo", studentJob);
        PartTimeUser ta = new PartTimeUser("Jane Smith", 25, "Alexandria", taJob);
        FullTimeUser lecturer = new FullTimeUser("Dr. Ahmed", 35, "Giza", lecturerJob);

        // Create messages
        Message publicMsg = new PublicMessage("Hello Everyone", "This is a public message", student, ta);
        Message privateMsg = new PrivateMessage("Private Note", "This is a private message", student, lecturer);

        // Test sending messages
        System.out.println("=== Message Sending Tests ===");
        
        // Test 1: Student sending messages
        System.out.println("\nStudent Message Tests:");
        sendMessage(student, ta, publicMsg);  // Should fail (student can only send to students)
        sendMessage(student, lecturer, privateMsg);  // Should fail (student can only send to students)
        
        // Test 2: TA sending messages
        System.out.println("\nTA Message Tests:");
        sendMessage(ta, student, publicMsg);  // Should succeed (TA can send to students)
        sendMessage(ta, lecturer, publicMsg);  // Should succeed (TA can send to lecturers of same specialty)
        
        // Test 3: Lecturer sending messages
        System.out.println("\nLecturer Message Tests:");
        sendMessage(lecturer, student, publicMsg);  // Should succeed (lecturer can send to anyone)
        sendMessage(lecturer, ta, publicMsg);  // Should succeed (lecturer can send to anyone)
        
        // Test 4: PartTimeUser (TA) sending to FullTimeUser
        System.out.println("\nPartTimeUser to FullTimeUser Test:");
        sendMessage(ta, student, publicMsg);  // Should succeed (PartTimeUser can send to FullTimeUser)
        
        // Test 5: FullTimeUser sending messages
        System.out.println("\nFullTimeUser Message Tests:");
        sendMessage(student, ta, publicMsg);  // Should succeed (FullTimeUser can send to PartTimeUser)
        sendMessage(lecturer, ta, publicMsg);  // Should succeed (FullTimeUser can send to PartTimeUser)

        // Test deleting messages
        System.out.println("\n=== Message Deletion Tests ===");
        deleteMessage(ta, publicMsg);
        deleteMessage(student, privateMsg);
    }

    /**
     * Helper method to send a message between users.
     */
    private static void sendMessage(User sender, User receiver, Message msg) {
        if (sender.sendMsg(receiver, msg) && msg.canSend()) {
            receiver.receiveMsg(msg);
            sender.getSent().add(msg);
            System.out.println(sender.getName() + " sent a message to " + receiver.getName());
        } else {
            System.out.println(sender.getName() + " could NOT send a message to " + receiver.getName());
        }
    }

    /**
     * Helper method to delete a message from a user's inbox.
     */
    private static void deleteMessage(User user, Message msg) {
        System.out.println(user.getName() + " deleting message: " + (user.deleteMsg(msg) ? "Success" : "Failed"));
    }
}
