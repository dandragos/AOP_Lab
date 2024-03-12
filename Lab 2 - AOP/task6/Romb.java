package lab2.task6;

public class Romb extends Paralelogram{
    private double diag1,diag2;
    public Romb() {
        super();
    }
    public Romb(int latura1,int latura2) {
        super(latura1, latura2, latura1, latura2);
        diag1=Math.sqrt(Math.pow(latura1,2)/2);
        diag2=Math.sqrt(Math.pow(latura2,2)/2);
    }
    public Romb(double unghi1,double unghi2) {
        super(0, 0, unghi1, unghi2);
    }
    public Romb(int latura1,int latura2,double unghi1,double unghi2) {
        super(latura1,latura2, unghi1, unghi2);
    }
    @Override
    public double arie(){
        return (diag1*diag2)/2;
    }
}
