import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take two numbers as input
        System.out.print("Enter the first number (a): ");
        double a = sc.nextDouble();

        System.out.print("Enter the second number (b): ");
        double b = sc.nextDouble();

        // Show operation choices
        System.out.println("Choose an operation:");
        System.out.println("1: Addition (+)");
        System.out.println("2: Subtraction (-)");
        System.out.println("3: Multiplication (*)");
        System.out.println("4: Division (/)");
        System.out.println("5: Modulo (%)");

        System.out.print("Enter your choice (1 to 5): ");
        int choice = sc.nextInt();

        double result;
        switch (choice) {
            case 1:
                result = a + b;
                System.out.println("Result: " + result);
                break;
            case 2:
                result = a - b;
                System.out.println("Result: " + result);
                break;
            case 3:
                result = a * b;
                System.out.println("Result: " + result);
                break;
            case 4:
                if (b != 0) {
                    result = a / b;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            case 5:
                if (b != 0) {
                    result = a % b;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Modulo by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please select between 1 and 5.");
        }

        sc.close();
    }
}
