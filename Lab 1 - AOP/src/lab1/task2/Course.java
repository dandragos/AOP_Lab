package lab1.task2;
import lab1.task2.Student;
import java.util.Random;

public class Course {
    private String name;
    private double minimumGrade;
    private Student[] students;

    public Course(String name, double minimumGrade, Student[] students) {
        this.name = name;
        this.minimumGrade = minimumGrade;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public double getMinimumGrade() {
        return minimumGrade;
    }

    public Student[] getStudents() {
        return students;
    }

    public Student chooseStudentRandomly() {
        Random random = new Random();
        int index = random.nextInt(students.length);
        return students[index];
    }

    public Student[] showAllPassingStudents() {
        int count = 0;
        for (Student student : students) {
            if (student.getGrade() >= minimumGrade) {
                count++;
            }
        }
        Student[] passingStudents = new Student[count];
        int index = 0;
        for (Student student : students) {
            if (student.getGrade() >= minimumGrade) {
                passingStudents[index] = student;
                index++;
            }
        }
        return passingStudents;
    }

    public boolean isStudentPassing(Student studentToCheck) {
        for (Student student : students) {
            if (student.equals(studentToCheck)) {
                return student.getGrade() >= minimumGrade;
            }
        }
        return false;
    }
}
