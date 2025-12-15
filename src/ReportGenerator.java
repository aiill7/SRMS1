import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ReportGenerator {

    public static void reportByGPA(ArrayList<Student> students) {
        System.out.println("=== Report By GPA (High to Low) ===");
        students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .forEach(s -> System.out.println(
                        s.getId() + " | " + s.getName() + " | GPA: " + s.getGpa()
                ));
    }

    public static void reportByDepartment(ArrayList<Student> students) {
        System.out.println("=== Report By Department ===");
        HashMap<String, ArrayList<Student>> map = new HashMap<>();

        for (Student s : students) {
            map.putIfAbsent(s.getDepartment(), new ArrayList<>());
            map.get(s.getDepartment()).add(s);
        }

        for (String dept : map.keySet()) {
            System.out.println("Department: " + dept);
            for (Student s : map.get(dept)) {
                System.out.println("  " + s.getId() + " - " + s.getName() + " | GPA: " + s.getGpa());
            }
            System.out.println();
        }
    }

    public static void reportByYear(ArrayList<Student> students) {
        System.out.println("=== Report By Year ===");
        HashMap<Integer, ArrayList<Student>> map = new HashMap<>();

        for (Student s : students) {
            map.putIfAbsent(s.getYear(), new ArrayList<>());
            map.get(s.getYear()).add(s);
        }

        for (int year : map.keySet()) {
            System.out.println("Year: " + year);
            for (Student s : map.get(year)) {
                System.out.println("  " + s.getId() + " - " + s.getName()
                        + " | Dept: " + s.getDepartment() + " | GPA: " + s.getGpa());
            }
            System.out.println();
        }
    }
}
