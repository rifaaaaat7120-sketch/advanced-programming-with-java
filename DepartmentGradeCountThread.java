import java.util.List;
import java.util.Map;
import java.util.EnumMap;
import java.util.LinkedHashMap;

public class DepartmentGradeCountThread extends Thread {
    private List<Student> students;

    private static final String[] GRADES = {
            "A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"
    };

    public DepartmentGradeCountThread(List<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        Map<Department, Map<String, Integer>> counts =
                new EnumMap<>(Department.class);

        for (Department department : Department.values()) {
            Map<String, Integer> gradeCounts =
                    new LinkedHashMap<>();

            for (String grade : GRADES) {
                gradeCounts.put(grade, 0);
            }

            counts.put(department, gradeCounts);
        }

        for (Student student : students) {
            Department department = student.getDepartment();
            String grade = student.getLetterGrade();

            Map<String, Integer> gradeCounts =
                    counts.get(department);

            gradeCounts.put(
                    grade,
                    gradeCounts.get(grade) + 1
            );
        }

        System.out.println("\nDepartment-Wise Grade Count:");

        for (Department department : Department.values()) {
            System.out.print(department + ": ");

            Map<String, Integer> gradeCounts =
                    counts.get(department);

            for (String grade : GRADES) {
                System.out.print(
                        grade + "=" + gradeCounts.get(grade)
                                + (grade.equals("F") ? "" : ", ")
                );
            }

            System.out.println();
        }
    }
}