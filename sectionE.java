package Calc;

import java.util.Scanner;

public class sectionE {

    // Factorial method
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            return 1;
        }
        int progress = (int) (((originalNum - num) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
    }

    // Recursive method for permutations
    public static long permutationsRecursive(int total, int select) {
        if (total < 0 || select < 0 || total > 100 || select > total) {
            System.out.println("Invalid input: Ensure 0 <= select <= total <= 100 and both values are non-negative.");
            return -1;
        }
        return permutationsHelper(total, select);
    }

    private static long permutationsHelper(int total, int select) {
        if (select == 0) {
            return 1;
        }
        return total * permutationsHelper(total - 1, select - 1);
    }

    // Non-recursive method for permutations
    public static long permutationsNonRecursive(int total, int select) {
        if (total < 0 || select < 0 || total > 100 || select > total) {
            System.out.println("Invalid input: Ensure 0 <= select <= total <= 100 and both values are non-negative.");
            return -1;
        }
        long result = 1;
        for (int i = 0; i < select; i++) {
            result *= (total - i);
        }
        return result;
    }

    // Main method to handle user input and operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter operation (factorial, permutations) or 'exit' to quit:");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            if (operation.equalsIgnoreCase("factorial")) {
                System.out.print("Enter number to calculate factorial: ");
                int num = scanner.nextInt();
                System.out.println("Result: " + factorial(num));
            } else if (operation.equalsIgnoreCase("permutations")) {
                System.out.print("Enter total number of items: ");
                int total = scanner.nextInt();
                System.out.print("Enter number of items to select: ");
                int select = scanner.nextInt();

                System.out.println("Choose method: 1 for Recursive, 2 for Non-Recursive");
                int method = scanner.nextInt();

                long result = (method == 1) ? permutationsRecursive(total, select) : permutationsNonRecursive(total, select);

                if (result != -1) {
                    System.out.println("Result: " + result);
                }
            } else {
                System.out.println("Invalid operation. Please enter 'factorial', 'permutations', or 'exit'.");
            }
        }

        scanner.close();
    }
}