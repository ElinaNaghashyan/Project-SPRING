package FinalBilliard;

public class Line {

    private Point P1;
    private Moment M1;
    private double slope = M1.getPy() / M1.getPx();
    private double yIntersection = -M1.getPy() / M1.getPx() * P1.getX() + P1.getY();;

    public void setP1(Point p1) {
        this.P1 = p1;
    }

    public void setM1(Moment m1) {
        this.M1 = m1;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public void setY_Intersection(double yIntersection) {
        this.yIntersection = yIntersection;
    }

    public Line(Point p, Moment m){
        P1 = p;
        M1 = m;
    }
    public Point getP1() {
        return P1;
    }

    public Moment getM1() {
        return M1;
    }

    public double getSlope() {
        return slope;
    }

    public double getyIntersection() {
        return yIntersection;
    }

    public Line(double slope, double yIntersection) {
        this.slope = slope;
        this.yIntersection = yIntersection;
    }

    public Line getLine(){
        slope = M1.getPy() / M1.getPx();
        yIntersection = -M1.getPy() / M1.getPx() * P1.getX() + P1.getY();
        return new Line(slope, yIntersection);
    }
}

