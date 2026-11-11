public class WebDevelopper extends ITClub implements ProjectWork, Codingable {
    private String design_tool; private int project_count;
    public WebDevelopper(String name, int course, String department, String skill, String id, String pl,
                         String design_tool, int project_count) {
        super(name, course, department, skill, id, pl);
        this.design_tool = design_tool; this.project_count = project_count;
    }
    public String getDesign_tool() { return design_tool; }
    public void setDesign_tool(String d) { this.design_tool = d; }
    public int getProject_count() { return project_count; }
    public void setProject_count(int c) { if (c >= 0) this.project_count = c; }
    @Override public void learnskill() { System.out.println(getName() + " has Web developing skill in " + design_tool); }
    @Override public void doProject() { project_count++; }
    @Override public void showProject() { System.out.println(getName() + " has " + project_count + " projects "); }
    @Override public void knowCoding() { System.out.println(getName() + " know " + getPl() + " for web developping "); }
}
