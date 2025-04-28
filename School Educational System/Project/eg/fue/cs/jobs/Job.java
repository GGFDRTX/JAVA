package eg.fue.cs.jobs;

public class Job {
    private String name;
    private String description;
    private String faculty;
    private String department;

    // Default constructor
    public Job() {
        this.name = "";
        this.description = "";
        this.faculty = "";
        this.department = "";
    }

    // Parameterized constructor
    public Job(String name, String description, String faculty, String department) {
        this.name = name;
        this.description = description;
        this.faculty = faculty;
        this.department = department;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
