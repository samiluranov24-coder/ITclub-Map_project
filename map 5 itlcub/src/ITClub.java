import java.util.*;

public abstract class ITClub implements Comparable<ITClub> {   // Block C: natural ordering
    public abstract void learnskill();
    public abstract void doProject();
    private String name; private int course; private String department;
    private String skill; private String id; private String pl;
    private final Set<IT_Project> projects = new HashSet<>();   // N:M with IT_Project


    public ITClub(String name, int course, String department, String skill, String id, String pl) {
        this.name = name; setCourse(course); this.department = department;
        this.skill = skill; this.id = id; this.pl = pl;
    }
    public String getName() { return name; }
    public int getCourse() { return course; }
    public void setCourse(int course) { if (course > 0) this.course = course; }
    public String getDepartment() { return department; }
    public void setDepartment(String d) { if (d != null && !d.isEmpty()) this.department = d; }
    public String getSkill() { return skill; }
    public void setSkill(String s) { if (s != null && !s.isEmpty()) this.skill = s; }
    public String getId() { return id; }
    public void setId(String id) { if (id != null && !id.isEmpty()) this.id = id; }
    public String getPl() { return pl; }
    public void setPl(String pl) { if (pl != null && !pl.isEmpty()) this.pl = pl; }
    public Set<IT_Project> getProjects() { return projects; }

    public void displayInfo() {
        System.out.println("Name " + name);
        System.out.println("Course is " + course);
        System.out.println("Department: " + department);
        System.out.println("Skill is: " + skill);
        System.out.println("ID number is: " + id);
        System.out.println("Programming language is " + pl);
    }
    // Block A: equals/hashCode by business key (id)
    @Override public boolean equals(Object o) {   // not enter dublicates
        if (this == o) return true;
        if (!(o instanceof ITClub)) return false;
        return Objects.equals(id, ((ITClub) o).id);
    }
    @Override public int hashCode() { return Objects.hash(id); }      //fast search
    @Override public int compareTo(ITClub o) { return id.compareTo(o.id); }   // natural order: by ID
    @Override public String toString() { return name + "(" + id + ", " + department + ", course " + course + ")"; }
}

