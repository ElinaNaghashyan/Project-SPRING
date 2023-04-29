import java.util.ArrayList;
import java.util.List;

public class ConverterInt extends Converter {
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
        int n = binary.length();
        List<Double> springs = new ArrayList<Double>();
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '1') {
                springs.add((double) (i + 1));
            }
        }
        return springs;
    }

    @Override
    public List<Double> springSystem(List<Integer> bits) {
        return null;
    }

    @Override
    public double evaluateDecimalValue(String binary) {
        int decimal = 0;
        int n = binary.length();
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, n - 1 - i);
            }
        }
        return decimal;
    }

    @Override
    public double evaluateFloatDecimalValue(String binary1, String binary2) {
        return 0;
    }

    // Test cases in main function
    public static void main(String[] args) {
        ConverterInt converter = new ConverterInt();
        String binary1 = "10101010";
        String binary2 = "11111000";
        List<Double> springs1 = converter.convertToSprings(binary1);
        List<Double> springs2 = converter.convertToSprings(binary2);
        System.out.println(binary1);
        System.out.println(converter.evaluateDecimalValue(binary1));
        System.out.println(springs1);
        System.out.println();
        System.out.println(binary2);
        System.out.println(converter.evaluateDecimalValue(binary2));
        System.out.println(springs2);
    }

    //Used chatGPT in some places
}
