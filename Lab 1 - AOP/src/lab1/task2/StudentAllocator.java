package lab1.task2;

public class StudentAllocator {
    public static Student[] createStudents(String[] names, double[] grades) {
        if (names.length != grades.length) {
            throw new IllegalArgumentException("Number of names must match number of grades");
        }
        Student[] students = new Student[names.length];
        for (int i = 0; i < names.length; i++) {
            students[i] = new Student(names[i], grades[i]);
        }
        return students;
    }
}