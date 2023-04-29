
public class Spring {

    private double k = 1;

    public Spring() {}

    public Spring(double k) {
        this.k = k;
    }
    public double getStiffness() {
        return k;
    }
    private void setStiffness(double k) {
        this.k = k;
    }

    public double[] move(double t, double dt, double x0, double v0) {
        int steps = (int)(t/dt)+1;
        double[] coordinates = new double[steps];
        coordinates[0] = x0;
        double velocity= v0;
        for (int i = 1; i < steps; i++) {
            double acceleration = -k * coordinates[i - 1];
            coordinates[i] = coordinates[i - 1] + velocity * dt + 0.5 * acceleration * Math.sqrt(dt);
            velocity += acceleration * dt;
        }
        return coordinates;
    }

    public double[] move(double t, double dt, double x0) {
        return move(t, dt, x0, 0);
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0) {
        int steps = (int) ((t1 - t0) / dt) + 1;
        double[] coordinates = new double[steps];
        coordinates[0] = x0;
        double velocity = v0;
        for (int i = 1; i < steps; i++) {
            double acceleration = -k * coordinates[i-1];
            coordinates[i] = coordinates[i-1] + velocity * dt + 0.5 * acceleration * Math.sqrt(dt);
            velocity += acceleration * dt;
        }

        return coordinates;
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0, double m) {
        int steps = (int) ((t1 - t0) / dt) + 1;
        double[] coordinates = new double[steps];
        coordinates[0] = x0;
        double velocity = v0;
        double acceleration = -k * x0 / m;
        for (int i = 1; i < steps; i++) {
            coordinates[i] = coordinates[i-1] + velocity * dt + 0.5 * acceleration * Math.sqrt(dt);
            velocity += acceleration * dt;
            acceleration = -k * coordinates[i] / m;
        }

        return coordinates;
    }

    public Spring inSeries(Spring that) {
        double eqStiffness = (this.k * that.k) / (this.k + that.k);
        return new Spring(eqStiffness);
    }

    public Spring inParallel(Spring that) {
        double eqStiffness = this.k + that.k;
        return new Spring(eqStiffness);
    }
}




