package lab2.task6;

public class Paralelogram extends Patrulater{
    public Paralelogram(){
        super();
    }
    public Paralelogram(int latura1, int latura2) {
        super(latura1, latura2, latura1, latura2);
    }
    public Paralelogram(int latura1, int latura2,
                        double unghi1, double unghi2) {
        super(latura1,latura2,latura1,latura2, unghi1, unghi2, unghi1, unghi2);
    }
    public double arie(){
        return latura1*latura2*Math.sin(Math.toRadians(unghi1));
    }


}
