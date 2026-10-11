public class Main {
    public static void main(String[] args) throws InterruptedException {

        Student[] students = {
                new Student(101, "Rahim", Department.CSE, 50, 40, 30),
                new Student(102, "Karim", Department.CSE, 70, 85, 60),
                new Student(103, "Ayesha", Department.EEE, 90, 95, 92),
                new Student(104, "Nusrat", Department.EEE, 60, 35, 60),
                new Student(105, "Sakib", Department.BBA, 95, 87, 75),
                new Student(106, "Mim", Department.BBA, 30, 46, 80)
        };

        System.out.println("Student Information:");

        for (Student student : students) {
            int[] marks = student.getMarks();

            System.out.println(
                    student.getId() + ", "
                            + student.getName() + ", "
                            + student.getDepartment() + ", "
                            + "[" + marks[0] + ", "
                            + marks[1] + ", " + marks[2] + "]"
            );
        }

        Thread[] threads = new Thread[students.length * 2];
        int index = 0;

        for (Student student : students) {
            threads[index] = new TotalMarksThread(student);
            threads[index].start();
            index++;

            threads[index] = new AverageMarksThread(student);
            threads[index].start();
            index++;
        }

        for (Thread thread : threads) {
            thread.join();
        }
        for (Student student : students) {
            if (student.getName().equals("Ayesha")) {
                System.out.println(
                        "\nTotal Marks for " + student.getName()
                                + ": " + student.getTotalMarks()
                );

                System.out.printf(
                        "Average Marks for %s: %.2f%n",
                        student.getName(),
                        student.getAverageMarks()
                );

                System.out.println(
                        "Letter Grade for " + student.getName()
                                + ": " + student.getLetterGrade()
                );

                System.out.printf(
                        "Grade Point for %s: %.2f%n",
                        student.getName(),
                        student.getGradePoint()
                );
            }
        }

        DepartmentGradeCountThread gradeCountThread =
                new DepartmentGradeCountThread(
                        java.util.Arrays.asList(students)
                );

        gradeCountThread.start();
        gradeCountThread.join();

        System.out.println("Result processing completed.");
    }
}