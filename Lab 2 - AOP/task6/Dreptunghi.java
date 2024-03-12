package lab2.task6;

public class Dreptunghi extends Paralelogram{
    public Dreptunghi() {
        super();
    }
    public Dreptunghi(int latura1, int latura2) {
        super(latura1, latura2, latura1,latura2);
    }
    public Dreptunghi(int latura1, int latura2,
                double unghi1, double unghi2) {
        super(latura1,latura2, unghi1, unghi2);
    }
    public double arie(){
        return latura1*latura2;
    }
}
