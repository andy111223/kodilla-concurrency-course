package simpleProjectAssignment;

public class StudentProjectAssignment {
    private final String studentName;
    private final int projectId;
    private String projectName;

    public StudentProjectAssignment(String studentName, int projectId) {
        this.studentName = studentName;
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "\nStudent: " + studentName + " - project: " + projectName;
    }
}
