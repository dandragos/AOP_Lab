package lab2.task6;
import java.text.MessageFormat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Paralelogram: ");
        Paralelogram pr = new Paralelogram(3,6,30,60);
        System.out.println(MessageFormat.format("Arie: {0}, Perimetru: {1}",pr.arie(),pr.perimetru()));

        System.out.println("Romb: ");
        Romb r = new Romb(3,4);
        System.out.println(MessageFormat.format("Arie: {0}, Perimetru: {1}",r.arie(),r.perimetru()));

        System.out.println("Dreptunghi: ");
        Dreptunghi d = new Dreptunghi(1,3);
        System.out.println(MessageFormat.format("Arie: {0}, Perimetru: {1}",d.arie(),d.perimetru()));

        System.out.println("Patrat: ");
        Patrat p = new Patrat(3);
        System.out.println(MessageFormat.format("Arie: {0}, Perimetru: {1}",p.arie(),p.perimetru()));
    }
}
