public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int oddCounter = 2;
        double fibonacciCurr = 1, fibonacciPrev = 1;
        System.out.printf("The first %d Fibonacci numbers are:%n%.0f %.0f", x, fibonacciCurr, fibonacciPrev);
        for (int i = 2; i < x; i++) {
            fibonacciCurr += fibonacciPrev;
            fibonacciPrev = fibonacciCurr - fibonacciPrev;
            oddCounter += fibonacciCurr % 2;
            System.out.printf(" %.0f", fibonacciCurr);
        }
        System.out.printf("%nThe number of odd numbers is: %d%n", oddCounter);
    }
}
