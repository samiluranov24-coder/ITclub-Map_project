
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static Scanner in = new Scanner(System.in);
    static ClubService s = new ClubService();

    static String str(String m) {
        System.out.print(m);
        return in.nextLine().trim();
    }

    // Enter number
    static int num(String m) {
        while (true) {
            try {
                return Integer.parseInt(str(m));
            } catch (Exception e) {
                System.out.println("Enter number!");
            }
        }
    }

    // Read member information from keyboard
    static ITClub readMember() {

        String name = str("Name: ");
        int course = num("Course: ");
        String dep = str("Department: ");
        String skill = str("Skill: ");
        String id = str("ID: ");
        String pl = str("Language: ");

        if (id.isEmpty() || course <= 0) return null;

        switch (dep.toLowerCase()) {

            case "programming":
                return new Programming(
                        name, course, dep, skill, id, pl,
                        str("Specialization: "),
                        str("GitHub: ")
                );

            case "webdeveloper":
                return new WebDevelopper(
                        name, course, dep, skill, id, pl,
                        str("Design tool: "),
                        num("Projects: ")
                );

            case "cybersecurity":
                return new Cybersecurity(
                        name, course, dep, skill, id, pl,
                        str("Tool: "),
                        str("Certificate: ")
                );

            default:
                System.out.println("Unknown department!");
                return null;
        }
    }

    // Print members
    static void print(List<ITClub> list) {
        if (list.isEmpty())
            System.out.println("Empty");

        list.forEach(System.out::println);
    }

    // LOAD MEMBERS FROM TEXT FILE
    static void loadMembersFromFile(String filename) {

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(";", -1);

                if (parts.length != 9) {
                    System.out.println("Invalid data: " + line);
                    continue;
                }

                String type = parts[0];
                String name = parts[1];
                int course = Integer.parseInt(parts[2]);
                String dep = parts[3];
                String skill = parts[4];
                String id = parts[5];
                String language = parts[6];

                ITClub member = null;

                switch (type.toLowerCase()) {

                    case "programming":
                        member = new Programming(
                                name, course, dep, skill, id, language,
                                parts[7], parts[8]
                        );
                        break;

                    case "webdeveloper":
                        member = new WebDevelopper(
                                name, course, dep, skill, id, language,
                                parts[7],
                                Integer.parseInt(parts[8])
                        );
                        break;

                    case "cybersecurity":
                        member = new Cybersecurity(
                                name, course, dep, skill, id, language,
                                parts[7], parts[8]
                        );
                        break;

                    default:
                        System.out.println("Unknown member type: " + type);
                }

                if (member != null) {
                    System.out.println(
                            s.add(member)
                                    ? "Member loaded: " + name
                                    : "Duplicate ID: " + id
                    );
                }
            }

            System.out.println("All file data processed!");

        } catch (IOException e) {
            System.out.println("File not found: " + filename);
        } catch (Exception e) {
            System.out.println("File format error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Add default members
        s.add(new Programming(
                "Aruuke", 2, "Programming", "Java",
                "P001", "Java", "AI", "aruuke123"
        ));

        s.add(new WebDevelopper(
                "Aida", 1, "WebDeveloper", "HTML",
                "P002", "JavaScript", "Figma", 3
        ));

        s.add(new Cybersecurity(
                "Meerim", 2, "Cybersecurity",
                "Network", "P003", "Python",
                "Nmap", "Certificate"
        ));

        // Load members from text file
        loadMembersFromFile("Data.txt");

        Club_President president = new Club_President("Aruuke");
        boolean run = true;

        while (run) {

            System.out.println("""
                    1 Add  2 Request  3 Process
                    4 Find  5 Filter  6 Update
                    7 Delete  8 Projects  9 Sort
                    10 Info  11 Report  12 President
                    13 Group  0 Exit
                    """);

            switch (num("Choice: ")) {

                case 1:
                    ITClub m = readMember();

                    if (m != null)
                        System.out.println(
                                s.add(m) ? "Added" : "Duplicate ID"
                        );
                    break;

                case 2:
                    m = readMember();

                    if (m != null)
                        s.submit(new JoinRequest(m, num("Priority: ")));
                    break;

                case 3:
                    president.processRequests(s, num("Count: "));
                    break;

                case 4:
                    System.out.println(s.find(str("ID: ")));
                    break;

                case 5:
                    String d = str("Department (empty = course): ");

                    print(d.isEmpty()
                            ? s.byMinCourse(num("Minimum course: "))
                            : s.byDepartment(d));
                    break;

                case 6:
                    String id = str("ID: ");
                    ITClub member = s.find(id);

                    if (member == null) break;

                    int choice = num(
                            "1 Course  2 Department  3 Skill  4 ID: "
                    );

                    if (choice == 1)
                        member.setCourse(num("Course: "));

                    if (choice == 2)
                        s.changeDepartment(id, str("Department: "));

                    if (choice == 3)
                        member.setSkill(str("Skill: "));

                    if (choice == 4)
                        s.changeId(id, str("New ID: "));

                    break;

                case 7:
                    System.out.println(s.remove(str("ID: ")));
                    break;

                case 8:
                    if (num("1 Create  2 Join: ") == 1) {

                        s.addProject(new IT_Project(
                                str("Name: "),
                                str("Deadline: "),
                                str("Description: "),
                                num("Tasks: ")
                        ));

                    } else {

                        System.out.println(
                                s.join(
                                        str("Member ID: "),
                                        str("Project: ")
                                )
                        );
                    }
                    break;

                case 9:
                    print(s.sorted(Comparators.BY_NAME));

                    print(s.sorted(
                            Comparators.BY_COURSE_THEN_NAME
                    ));

                    print(s.sorted(
                            Comparators.BY_DEPT_THEN_COURSE_DESC
                    ));
                    break;

                case 10:
                    for (ITClub x : s.all()) {
                        x.displayInfo();
                        x.learnskill();
                        x.doProject();
                    }
                    break;

                case 11:
                    s.report();
                    break;

                case 12:
                    IT_Project p = s.project(str("Project name: "));

                    if (p != null)
                        president.announceProject(p);
                    break;

                case 13:
                    ITClub_Group g = new ITClub_Group("IT Club");

                    s.all().forEach(g::addMember);

                    g.displayInfo();
                    break;

                case 0:
                    run = false;
                    break;
            }
        }

        in.close();
    }
}
