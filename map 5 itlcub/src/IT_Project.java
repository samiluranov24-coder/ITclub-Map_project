import java.util.*;

public class IT_Project {
    private String projectName;
    private String deadline;
    private ProjectPlan plan;                                  // Composition
    private final Set<ITClub> participants = new HashSet<>();  // N:M with ITClub

    public IT_Project(String projectName, String deadline, String description, int numberOfTasks) {
        this.projectName = projectName; this.deadline = deadline;
        this.plan = new ProjectPlan(description, numberOfTasks);
    }
    public String getProjectName() { return projectName; }
    public Set<ITClub> getParticipants() { return participants; }
    public void addParticipant(ITClub m) { participants.add(m); m.getProjects().add(this); }
    public void removeParticipant(ITClub m) { participants.remove(m); m.getProjects().remove(this); }
    public void displayProject() {
        System.out.println("Project Name: " + projectName);
        System.out.println("Deadline: " + deadline);
        plan.displayPlan();
        System.out.println("Participants: " + participants.size());
    }
    @Override public boolean equals(Object o) {
        return o instanceof IT_Project && Objects.equals(projectName, ((IT_Project) o).projectName);
    }
    @Override public int hashCode() { return Objects.hash(projectName); }
}
