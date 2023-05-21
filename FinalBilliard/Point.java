package FinalBilliard;

import java.text.DecimalFormat;
        import java.util.Random;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point generatePointInsideUnitCircle() {
        Random random = new Random();
        double x = Double.parseDouble(new DecimalFormat("##.####").format(-1 + (2 * random.nextDouble())));
        double y = Double.parseDouble(new DecimalFormat("##.####").format(-1 + (2 * random.nextDouble())));

        return new Point(x,y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
