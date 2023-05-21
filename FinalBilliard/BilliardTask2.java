package FinalBilliard;

public class BilliardTask2 {

        private Point p;
        private Moment m;

        public double function(double x) {
            double X1 = p.getX();
            double Y1 = p.getY();
            double vx = m.getPx();
            double vy = m.getPy();

            return Math.pow(Y1 + vy / vx - 10 / 2 * x * x / (vx * vx), 2) + x * x - 1;
        }

        public double root(double a, double b) {
            double c = (a + b) / 2;

            while (Math.abs(b - a) > 0.000001) {
                if (function(c) == 0.0) {
                    return c;
                } else if (function(a) * function(c) < 0) {
                    b = c;
                } else {
                    a = c;
                }
                c = (a + b) / 2;
            }
            return c;
        }

        public Point intersectionParabolaWithCircle() {
            double a = -10 / (2 * m.getPx());
            double b = m.getPy() / m.getPx();
            double c = p.getY();

            double vertexX = -b / (2 * a);
            double vertexY = -(b * b - 4 * a * c) / (4 * a);

            if (vertexX * vertexX + vertexY * vertexY <= 1) {
                double x = root(-1, 1);
                double y = function(x);
                return new Point(x, y);
            } else {
                return null;
            }
        }
    }



