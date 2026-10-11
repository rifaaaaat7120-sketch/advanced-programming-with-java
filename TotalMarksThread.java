public class TotalMarksThread extends Thread {
    private Student student;

    public TotalMarksThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        int total = 0;

        for (int mark : student.getMarks()) {
            total += mark;
        }

        student.setTotalMarks(total);
        student.setTotalMarks(total);
    }
}