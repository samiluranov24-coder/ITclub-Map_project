import java.util.Objects;

public class Club_President {
    private String name;

    public Club_President(String name) { this.name = name; }

    public void announceProject(IT_Project p) {
        System.out.println("President: " + name);
        p.displayProject();
    }

    public void processRequests(ClubService s, int count) {
        System.out.println("Processed: " + s.process(count));
    }

    public boolean equals(Object o) {
        return o instanceof Club_President &&
                Objects.equals(name, ((Club_President)o).name);
    }

    public int hashCode() { return Objects.hash(name); }
}