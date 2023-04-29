import java.util.Arrays;
import java.util.List;

public class Converter8Bit extends Converter {
    private Spring[] springs;

    public static void main(String[] args) {
        Converter8Bit converter = new Converter8Bit();
        int[] bits1 = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] bits2 = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println("Decimal:" + Arrays.toString(bits1) + " - " +
                converter.evaluateDecimalValue(Arrays.toString(bits1)));
        System.out.println("Decimal:" + Arrays.toString(bits2) + " - " +
                converter.evaluateDecimalValue(Arrays.toString(bits2)));
    }

    @Override
    public List<Double> computeSpringSystem(List<Integer> bits) {
        return null;
    }

    @Override
    public double evaluateDecimalValue(List<Integer> bits) {
        return 0;
    }

    @Override
    public List<Double> convertToSprings(String binary) {
        return null;
    }

    @Override
    public List<Double> springSystem(List<Integer> bits) {
        return null;
    }

    @Override
    public double evaluateDecimalValue(String binary) {
        return 0;
    }

    @Override
    public double evaluateFloatDecimalValue(String binary1, String binary2) {
        return 0;
    }
}

