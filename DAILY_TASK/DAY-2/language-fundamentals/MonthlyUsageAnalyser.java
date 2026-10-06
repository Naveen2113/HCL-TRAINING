public class MonthlyUsageAnalyser {

    public static void main(String[] args) {

        int[] monthlyUsage = {
            120, 250, 310, 450,
            520, 610, 580, 490,
            420, 350, 280, 200
        };

        System.out.println("=== Monthly Usage Analyser ===");

        int total = calculateTotal(monthlyUsage);
        int maximum = findMaximum(monthlyUsage);
        int minimum = findMinimum(monthlyUsage);

        double average = (double) total / monthlyUsage.length;

        char grade = calculateGrade(average);

        System.out.println("Total Usage: " + total);
        System.out.println("Average Usage: " + average);
        System.out.println("Maximum Usage: " + maximum);
        System.out.println("Minimum Usage: " + minimum);
        System.out.println("Usage Grade: " + grade);

        demonstrateTypeCasting();
        demonstrateOverflow();
        demonstrateFloatingPointPrecision();
        demonstrateTwoDimensionalArray();
        demonstrateOperatorPrecedence();
    }

    private static int calculateTotal(int[] usage) {

        int total = 0;

        for (int value : usage) {
            total += value;
        }

        return total;
    }

    private static int findMaximum(int[] usage) {

        int maximum = usage[0];

        for (int value : usage) {
            if (value > maximum) {
                maximum = value;
            }
        }

        return maximum;
    }

    private static int findMinimum(int[] usage) {

        int minimum = usage[0];

        for (int value : usage) {
            if (value < minimum) {
                minimum = value;
            }
        }

        return minimum;
    }

    private static char calculateGrade(double average) {

        return average >= Constants.GRADE_A_THRESHOLD
                ? 'A'
                : average >= Constants.GRADE_B_THRESHOLD
                ? 'B'
                : average >= Constants.GRADE_C_THRESHOLD
                ? 'C'
                : 'D';
    }

    private static void demonstrateTypeCasting() {

        System.out.println("\n=== Type Casting ===");

        int usage = 500;
        long largeUsage = usage;

        double preciseValue = 123.75;
        int integerValue = (int) preciseValue;

        System.out.println("Widening int to long: " + largeUsage);
        System.out.println("Narrowing double to int: " + integerValue);
    }

    private static void demonstrateOverflow() {

        System.out.println("\n=== Integer Overflow ===");

        int maxInt = Integer.MAX_VALUE;
        int overflowResult = maxInt + 1;

        System.out.println("Integer maximum: " + maxInt);
        System.out.println("Integer overflow result: " + overflowResult);

        long safeValue = (long) maxInt + 1;

        System.out.println("Using long: " + safeValue);
    }

    private static void demonstrateFloatingPointPrecision() {

        System.out.println("\n=== Floating-Point Precision ===");

        double first = 0.1;
        double second = 0.2;
        double result = first + second;

        System.out.println("0.1 + 0.2 = " + result);
    }

    private static void demonstrateTwoDimensionalArray() {

        System.out.println("\n=== 2-D Array: Three Houses ===");

        int[][] houseUsage = {
            {120, 150, 180, 200},
            {100, 130, 160, 190},
            {200, 220, 250, 280}
        };

        for (int house = 0; house < houseUsage.length; house++) {

            System.out.print("House " + (house + 1) + ": ");

            for (int month = 0; month < houseUsage[house].length; month++) {
                System.out.print(houseUsage[house][month]);

                if (month < houseUsage[house].length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }
    }

    private static void demonstrateOperatorPrecedence() {

        System.out.println("\n=== Operator Precedence ===");

        int result = 10 + 5 * 2;

        System.out.println("10 + 5 * 2 = " + result);
    }
}