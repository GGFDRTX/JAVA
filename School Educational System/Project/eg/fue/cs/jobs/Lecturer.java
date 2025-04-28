package eg.fue.cs.jobs;

public class Lecturer extends Job {
    private int noOfExperienceYears;

    // Default constructor
    public Lecturer() {
        super();
        this.noOfExperienceYears = 0;
    }

    // Parameterized constructor
    public Lecturer(String name, String description, String faculty, String department, int noOfExperienceYears) {
        super(name, description, faculty, department);
        this.noOfExperienceYears = noOfExperienceYears;
    }

    // Getters and setters
    public int getNoOfExperienceYears() {
        return noOfExperienceYears;
    }

    public void setNoOfExperienceYears(int noOfExperienceYears) {
        this.noOfExperienceYears = noOfExperienceYears;
    }
}
