package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Student {
    private String nume;
    private double notaLaborator;
    private double notaPartial;
    private double notaExamen;

    public Student(String nume, double notaLaborator, double notaPartial, double notaExamen) {
        this.nume = nume;
        this.notaLaborator = notaLaborator;
        this.notaPartial = notaPartial;
        this.notaExamen = notaExamen;
    }

    public double getNotaTotala() {
        return notaLaborator + notaPartial + notaExamen;
    }

    public double getNotaPartial() {
        return notaPartial;
    }

    public double getMedie() {
        return (notaLaborator + notaPartial + notaExamen) / 3;
    }

    public String toString() {
        return nume + " " + notaLaborator + " " + notaPartial + " " + notaExamen;
    }
}


class SortareStudenti {

    public static void sortareDupaNotaTotala(List<Student> studenti) {
        Collections.sort(studenti, Comparator.comparingDouble(Student::getNotaTotala).reversed());
        afisareListaStudenti("Sortare după cea mai mare notă totală", studenti);
    }


    public static void sortareDupaNotaPartiala(List<Student> studenti) {
        Collections.sort(studenti, Comparator.comparingDouble(Student::getNotaPartial).reversed());
        afisareListaStudenti("Sortare după cea mai mare notă la parțial", studenti);
    }


    public static void sortareDupaMedie(List<Student> studenti) {
        Collections.sort(studenti, Comparator.comparingDouble(Student::getMedie).reversed());
        afisareListaStudenti("Sortare după media notelor", studenti);
    }


    private static void afisareListaStudenti(String metoda, List<Student> studenti) {
        System.out.println(metoda);
        for (int i = 0; i < studenti.size(); i++) {
            System.out.println((i + 1) + ". " + studenti.get(i).toString());
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Aurel Vlaicu", 5.3, 7.8, 9.0));
        studenti.add(new Student("Liviu Teodorescu", 7.7, 5.2, 9.0));


        SortareStudenti.sortareDupaNotaTotala(studenti);
        SortareStudenti.sortareDupaNotaPartiala(studenti);
        SortareStudenti.sortareDupaMedie(studenti);
    }


}


// Design pattern folosit este Strategy deoarece in acest caz, diferitele metode de sortare sunt implementate ca strategii diferite, iar
// clasa GestionareSortare coordonează aplicarea acestor strategii.
