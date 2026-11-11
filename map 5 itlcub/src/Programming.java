
public class Programming extends ITClub implements ProjectWork, Codingable {
    private String specialization; private String github_name;
    public Programming(String name, int course, String department, String skill, String id, String pl,
                       String specialization, String github_name) {
        super(name, course, department, skill, id, pl);
        this.specialization = specialization; this.github_name = github_name;
    }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String s) { this.specialization = s; }
    public String getGithub_name() { return github_name; }
    public void setGithub_name(String g) { this.github_name = g; }
    @Override public void learnskill() { System.out.println(getName() + " is learning for " + specialization); }
    @Override public void doProject() { System.out.println(getName() + " is doing projects in " + specialization); }
    @Override public void showProject() { System.out.println(getName() + " has projects in Github " + github_name); }
    @Override public void knowCoding() { System.out.println(getName() + " obtains language for Programming in " + specialization); }
}
