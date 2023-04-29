import java.util.List;

public abstract class Converter {


    public abstract List<Double> computeSpringSystem(List<Integer> bits);

    public abstract double evaluateDecimalValue(List<Integer> bits);

    public abstract List<Double> convertToSprings(String binary);

    public abstract List<Double> springSystem(List<Integer> bits);

    public double computeDecimal(List<Integer> bits, double t) {
        List<Double> springSystem = springSystem(bits);
        double decimalNumber = 0;
        double n = 0;
        double k = 1;
        double mass = 1;
        double initialPosition = 0;
        double velocity = 1;
        double dt = 0.01;

        for (int j = 0; j < (int) (t / dt); j++) {
            double a = -k / mass * initialPosition;
            velocity += a * dt;
            initialPosition += velocity * dt;

            for (int i = 0; i < springSystem.size(); i++) {
                if (springSystem.get(i) == 0) {
                    break;
                } else {
                    int temp = (int) (springSystem.get(i) % 10);
                    decimalNumber += temp * Math.pow(2, n);
                    Double m = springSystem.get(i);
                    m = springSystem.get(i) / 10;
                    n++;

                }
                return decimalNumber;
            }

        }
        return decimalNumber;
    }

    public abstract double evaluateDecimalValue(String binary);

    public abstract double evaluateFloatDecimalValue(String binary1, String binary2);
}
