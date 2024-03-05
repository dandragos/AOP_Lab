package lab1.task1;

import lab1.task2.Student;
import lab1.task2.Course;
import lab1.task2.StudentAllocator;
import lab1.task4.DummyCalculator;

public class Main {
    public static void main(String[] args) {



        String[] names = {"George", "Alin", "Andrei", "Ion"};
        double[] grades = {7.5, 8.0, 4.5, 9.0};
        Student[] students = StudentAllocator.createStudents(names, grades);

        Course course = new Course("Matematica", 5.0, students);

        // Alege random
        System.out.println("Student Random: " + course.chooseStudentRandomly().getName());

        // Arata toti studentii care trec
        Student[] passingStudents = course.showAllPassingStudents();
        System.out.println("Passing students:");
        for (Student student : passingStudents) {
            System.out.println(student.getName());
        }

        // Verifica daca are nota de trecere
        System.out.println("Trece George? " + course.isStudentPassing(students[0]));
        System.out.println("Trece Andrei? " + course.isStudentPassing(students[2]));


        // DummyCalculator
        DummyCalculator calculator = new DummyCalculator();
        calculator.calculate(new String[]{"5", "+", "5"});
    }
}
