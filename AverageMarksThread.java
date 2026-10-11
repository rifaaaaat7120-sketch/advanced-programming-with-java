public class AverageMarksThread extends Thread {
    private Student student;

    public AverageMarksThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        int sum = 0;

        for (int mark : student.getMarks()) {
            sum += mark;
        }

        double average = sum / 3.0;
        student.setAverageMarks(average);

        student.calculateGrade();
    }
}