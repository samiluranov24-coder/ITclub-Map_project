public class ProjectPlan {
    private String description; private int numberOfTasks;
    public ProjectPlan(String description, int numberOfTasks) { this.description = description; this.numberOfTasks = numberOfTasks; }
    public void displayPlan() {
        System.out.println("Project Plan: " + description);
        System.out.println("Number of tasks: " + numberOfTasks);
    }
    @Override public boolean equals(Object o) { return o instanceof ProjectPlan && java.util.Objects.equals(description, ((ProjectPlan) o).description); }
    @Override public int hashCode() { return java.util.Objects.hash(description); }
}
//hashcode  equals    check if same object or not