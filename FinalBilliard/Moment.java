package FinalBilliard;

import java.util.Random;

public class Moment{
    private double px;
    private double py;

    public Moment(double px0, double py0) {
        px = px0;
        py = py0;
    }

    public static Moment generateRandomUnitMomentum1(){
        Random random = new Random();
        double px = random.nextDouble();
        double  py = random.nextDouble();
        while (!(Math.sqrt(px*px + py*py) <= 1 && (Math.sqrt(px*px + py*py) >= 0.99)))
        {
            px = random.nextDouble();
            py = random.nextDouble();
        }
        return new Moment(px,py);
    }

    public static Moment generateRandomUnitMomentum2(){
        Random random = new Random();
        double px = random.nextDouble();
        double py = random.nextDouble();
        while (!(Math.sqrt(px*px + py*py) <= 10 && (Math.sqrt(px*px + py*py) >= 5)))
        {
            px = random.nextDouble();
            py = random.nextDouble();
        }

        return new Moment(px,py);
    }

    public void setPx(double px) {
        this.px = px;
    }

    public void setPy(double py) {
        this.py = py;
    }

    public double getPx() {
        return px;
    }

    public double getPy() {
        return py;
    }
}
