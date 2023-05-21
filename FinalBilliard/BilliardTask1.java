package FinalBilliard;
import java.util.ArrayList;
import java.util.List;

public class BilliardTask1 {

    // I wrote the code for the first and second tasks with Ani Hakobyan

    private final int reflectionsNumber = 4;

    public Point intersectionLineWithCircle(Line line){

        double a = line.getSlope() + 1;
        double b = 2 * line.getSlope()*line.getyIntersection();
        double c = line.getyIntersection()* line.getyIntersection() - 1;
        double discriminant = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(discriminant))/(2*a);
        double x2 = (-b - Math.sqrt(discriminant))/(2*a);
        double y1 = line.getSlope()*x1 + line.getyIntersection();
        double y2 = line.getSlope()*x2 + line.getyIntersection();
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        return (line.getP1().getX() > x1) ? p1 : p2;
    }

    // I think there is no need to define a new momentum, since it is
    // equal to mass*velocity, mass is 1, so the momentum = velocity that does not change.

    public List<Line> calculateReflectionPoints(){

        Point initialPoint = Point.generatePointInsideUnitCircle();
        Moment momentum = Moment.generateRandomUnitMomentum1();
        List<Line> list = new ArrayList<>();
        list.add(new Line(initialPoint, momentum));
        Point newPoint = intersectionLineWithCircle(new Line(initialPoint, momentum));

        for(int i = 1; i < reflectionsNumber; i++){
            list.add(new Line(newPoint, momentum));
            newPoint = intersectionLineWithCircle(new Line(newPoint, momentum));
        }
        return list;
    }
    public List<Line> revers() {
        double deviation = 0.001;
        List<Line> lines = calculateReflectionPoints();
        Line lastLine = lines.get(lines.size() - 1);
        double px = -lastLine.getP1().getX();
        double py = -lastLine.getP1().getY();
        double x = lastLine.getP1().getX();
        double y = lastLine.getP1().getY();

        Point p = new Point(x,y);
        Moment m = new Moment(px,py);
        List<Line> reversed = new ArrayList<>();
        reversed.add(new Line(p, m));
        Point newPoint = intersectionLineWithCircle(new Line(p, m));

        for(int i = 1; i < reflectionsNumber; i++){
            reversed.add(new Line(newPoint, m));
            newPoint = intersectionLineWithCircle(new Line(p, m));
        }

        for(int i = 0; i < reversed.size(); i++){
            if(reversed.get(i).getSlope() - lines.get(lines.size()-i-1).getSlope() > deviation){
                System.out.println(i+1 + " -th reflection");
                break;
            }
        }

        return reversed;
    }

}
