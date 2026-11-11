public class Cybersecurity extends ITClub implements Codingable, ProjectWork {
    private String cybertool;
    private String certificate_name;
    public Cybersecurity(String name, int course, String department, String skill, String id, String pl,
                         String cybertool, String certificate_name) {
        super(name, course, department, skill, id, pl);
        this.cybertool = cybertool; this.certificate_name = certificate_name;
    }
    public String getCybertool() { return cybertool; }
    public void setCybertool(String c) { this.cybertool = c; }
    public String getCertificate_name() { return certificate_name; }
    public void setCertificate_name(String c) { this.certificate_name = c; }
    @Override public void learnskill() { System.out.println(getName() + " knows Fundamental " + cybertool); }
    @Override public void doProject() { System.out.println(" Project is doing by " + cybertool); }
    @Override public void showProject() { System.out.println("Certificate: " + certificate_name); System.out.println("Tool: " + cybertool); }
    @Override public void knowCoding() { System.out.println(getName() + " obtain " + getPl()); }
}

