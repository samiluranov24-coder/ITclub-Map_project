import java.util.*;

public class ClubService {
    private List<ITClub> members = new ArrayList<>();
    private Map<String, ITClub> byId = new HashMap<>();
    private Map<String, List<ITClub>> byDept = new TreeMap<>();
    private Map<String, IT_Project> projects = new LinkedHashMap<>();
    private Queue<JoinRequest> requests = new PriorityQueue<>(
            Comparator.comparingInt((JoinRequest r) -> -r.getPriority())
                    .thenComparingInt(JoinRequest::getSeq));
    //if same priority then first will be highest

    public boolean add(ITClub m) {
        if (byId.containsKey(m.getId())) return false;
        members.add(m);
        byId.put(m.getId(), m);
        byDept.computeIfAbsent(m.getDepartment(), k -> new ArrayList<>()).add(m);
        return true;
    }

    public ITClub find(String id) { return byId.get(id); }

    public boolean remove(String id) {
        ITClub m = byId.remove(id);
        if (m == null) return false;
        members.remove(m);
        byDept.get(m.getDepartment()).remove(m);
        for (IT_Project p : m.getProjects()) p.removeParticipant(m);
        return true;
    }

    public boolean changeId(String oldId, String newId) {
        ITClub m = find(oldId);
        if (m == null || newId == null || newId.isEmpty() || byId.containsKey(newId))
            return false;
        for (IT_Project p : m.getProjects()) p.getParticipants().remove(m);
        byId.remove(oldId);
        m.setId(newId);
        byId.put(newId, m);
        for (IT_Project p : m.getProjects()) p.getParticipants().add(m);
        return true;
    }

    public boolean changeDepartment(String id, String dep) {
        ITClub m = find(id);
        if (m == null || dep == null || dep.isEmpty()) return false;
        byDept.get(m.getDepartment()).remove(m);
        m.setDepartment(dep);
        byDept.computeIfAbsent(dep, k -> new ArrayList<>()).add(m);
        return true;
    }

    public List<ITClub> byDepartment(String d) {
        return new ArrayList<>(byDept.getOrDefault(d, List.of()));
    }

    public List<ITClub> byMinCourse(int c) {
        return members.stream().filter(m -> m.getCourse() >= c).toList();
    }

    public List<ITClub> sorted(Comparator<ITClub> c) {
        List<ITClub> l = new ArrayList<>(members);
        l.sort(c);
        return l;
    }

    public void addProject(IT_Project p) {
        projects.put(p.getProjectName(), p);
    }

    public IT_Project project(String name) { return projects.get(name); }

    public boolean join(String id, String name) {
        ITClub m = find(id);
        IT_Project p = project(name);
        if (m == null || p == null) return false;
        p.addParticipant(m);
        return true;
    }

    public void submit(JoinRequest r) { requests.offer(r); }

    public int process(int max) {
        int done = 0;
        while (done < max && !requests.isEmpty()) {
            JoinRequest r = requests.poll();
            System.out.println(r.getCandidate() +
                    (add(r.getCandidate()) ? " accepted" : " rejected"));
            done++;
        }
        return done;
    }

    public int pending() { return requests.size(); }

    public void report() {
        System.out.println("Total: " + members.size());
        byDept.forEach((d, l) -> System.out.println(d + ": " + l.size()));
        projects.values().forEach(p ->
                System.out.println(p.getProjectName() + ": " + p.getParticipants().size()));
    }

    public List<ITClub> all() { return new ArrayList<>(members); }
}