import java.util.*;

public class ITClub_Group {                                   // Aggregation
    private String groupName;
    private Set<ITClub> members = new LinkedHashSet<>();
    public ITClub_Group(String groupName) { this.groupName = groupName; }
    public void addMember(ITClub member) { members.add(member); }
    public void displayInfo() {
        System.out.println("IT Group name : " + groupName);
        System.out.println("========MEMBERS======");
        for (ITClub m : members) { m.displayInfo(); System.out.println("------------------"); }
    }
    @Override public boolean equals(Object o) { return o instanceof ITClub_Group && java.util.Objects.equals(groupName, ((ITClub_Group) o).groupName); }
    @Override public int hashCode() { return java.util.Objects.hash(groupName); }
}

