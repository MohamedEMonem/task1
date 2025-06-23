import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("Welcome to Java Console Calculator!");
        System.out.println("Enter mathematical expressions with spaces between numbers and operators.");
        System.out.println("Example: 2 + 2 - 1 * 3 / 4");
        System.out.println("Enter 'exit' to quit the calculator.");
        System.out.println("----------------------------------------");

        while (continueCalculating) {
            try {
                System.out.print("\nEnter your expression: ");
                String operation = sc.nextLine().trim();

                if (operation.equalsIgnoreCase("exit")) {
                    continueCalculating = false;
                    System.out.println("Thank you for using the calculator. Goodbye!");
                    continue;
                }

                if (operation.isEmpty()) {
                    System.out.println("Please enter a valid expression!");
                    continue;
                }

                String[] tokens = operation.split(" ");
                double result = calculateExpression(tokens);
                System.out.printf("Result: %.2f%n", result);

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers!");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Invalid expression format! Please use spaces between numbers and operators.");
            }
        }
        sc.close();
    }

    private static double calculateExpression(String[] tokens) {
        Stack<Double> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        // Validate input format
        if (tokens.length < 3 || tokens.length % 2 == 0) {
            throw new IllegalArgumentException("Invalid expression format!");
        }

        // Initialize the first number
        numberStack.push(Double.parseDouble(tokens[0]));

        // Process all tokens
        for (int i = 1; i < tokens.length; i += 2) {
            char operator = tokens[i].charAt(0);
            double number = Double.parseDouble(tokens[i + 1]);

            // Handle operator precedence
            while (!operatorStack.isEmpty() && hasPrecedence(operatorStack.peek(), operator)) {
                double b = numberStack.pop();
                double a = numberStack.pop();
                char op = operatorStack.pop();
                double result = applyOperator(a, b, op);
                numberStack.push(result);
            }

            operatorStack.push(operator);
            numberStack.push(number);
        }

        // Process remaining operators
        while (!operatorStack.isEmpty()) {
            double b = numberStack.pop();
            double a = numberStack.pop();
            char op = operatorStack.pop();
            double result = applyOperator(a, b, op);
            numberStack.push(result);
        }

        return numberStack.pop();
    }

    // Method overloading example with integer parameters
    public static int add(int a, int b) {
        return a + b;
    }

    // Method overloading example with double parameters
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed!");
        }
        return a / b;
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op1 == '*' || op1 == '/') {
            return true;
        }
        if ((op1 == '+' || op1 == '-') && (op2 == '+' || op2 == '-')) {
            return true;
        }
        return false;
    }

    private static double applyOperator(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return add(a, b);
            case '-':
                return subtract(a, b);
            case '*':
                return multiply(a, b);
            case '/':
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
