public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        int precision = Integer.parseInt(args[0]);
        double precisionSum = 0.0;
        for (int i = 0; i < precision; i++) {
            precisionSum += Math.pow(-1, i) / (2 * i + 1);
        }
        approxPi = 4 * precisionSum;

        System.out.println(approxPi + " " + actualPi);
    }
}
