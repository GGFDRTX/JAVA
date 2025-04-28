package eg.fue.cs.jobs;

public class Student extends Job {
    private int level;

    // Default constructor
    public Student() {
        super();
        this.level = 0;
    }

    // Parameterized constructor
    public Student(String name, String description, String faculty, String department, int level) {
        super(name, description, faculty, department);
        this.level = level;
    }

    // Getters and Setters
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}
