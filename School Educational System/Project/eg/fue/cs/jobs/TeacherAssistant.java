package eg.fue.cs.jobs;

public class TeacherAssistant extends Job {
    private int graduationYear;

    // Default constructor
    public TeacherAssistant() {
        super();
        this.graduationYear = 0;
    }

    // Parameterized constructor
    public TeacherAssistant(String name, String description, String faculty, String department, int graduationYear) {
        super(name, description, faculty, department);
        this.graduationYear = graduationYear;
    }

    // Getters and Setters
    public int getGraduationYear() { return graduationYear; }
    public void setGraduationYear(int graduationYear) { this.graduationYear = graduationYear; }
}
