public class Student {
    private int id;
    private String name;
    private Department department;
    private int[] marks;
    private int totalMarks;
    private double averageMarks;
    private String letterGrade;
    private double gradePoint;
    public Student(int id, String name,
                   Department department,
                   int mark1, int mark2, int mark3) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = new int[]{mark1, mark2, mark3};
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Department getDepartment() {
        return department;
    }
    public int[] getMarks() {
        return marks.clone();
    }
    public int getTotalMarks() {
        return totalMarks;
    }
    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }
    public double getAverageMarks() {
        return averageMarks;
    }
    public void setAverageMarks(double averageMarks) {
        this.averageMarks = averageMarks;
    }
    public String getLetterGrade() {
        return letterGrade;
    }
    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
    public double getGradePoint() {
        return gradePoint;
    }
    public void setGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
    }
    public void calculateGrade() {
        if (averageMarks >= 90) {
            letterGrade = "A+";
            gradePoint = 4.00;
        } else if (averageMarks >= 85) {
            letterGrade = "A";
            gradePoint = 3.75;
        } else if (averageMarks >= 80) {
            letterGrade = "B+";
            gradePoint = 3.50;
        } else if (averageMarks >= 75) {
            letterGrade = "B";
            gradePoint = 3.25;
        } else if (averageMarks >= 70) {
            letterGrade = "C+";
            gradePoint = 3.00;
        } else if (averageMarks >= 65) {
            letterGrade = "C";
            gradePoint = 2.75;
        } else if (averageMarks >= 60) {
            letterGrade = "D+";
            gradePoint = 2.50;
        } else if (averageMarks >= 50) {
            letterGrade = "D";
            gradePoint = 2.25;
        } else {
            letterGrade = "F";
            gradePoint = 0.00;
        }
    }
}

