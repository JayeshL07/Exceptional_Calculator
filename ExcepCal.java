package Exceptional_Calculator;

import java.util.Scanner;

public class ExcepCal {
    public static void main(String[] args) {
        System.out.println("Welcome to the Jay's Exceptional Calculator");
        exit exit = new exit();
        boolean j = false;
        do {
            System.out.println("Enter the operation which you want to perform");
            Scanner sc = new Scanner(System.in);
            char ch;
            do {
                String op = sc.next();
                ch = op.charAt(0);
                if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    System.out.println("Ok now enter the two numbers");
                    break;
                } else {
                    System.out.println("Enter the correct input");
                }
            } while (ch != '+' || ch != '-' || ch != '*' || ch != '/');
            float a = sc.nextFloat();
            float b = sc.nextFloat();
            if (a > 100000 || b > 100000) {
                try {
                    throw new MaxInput();
                } catch (MaxInput e) {
                    System.out.println(e.toString());
                }
            } else if (ch == '+') {
                try {
                    float result = add(a, b);
                    System.out.println(result);
                } catch (MaxInput e) {
                    System.out.println(e.toString());
                }
            } else if (ch == '-') {
                try {
                    float result = sub(a, b);
                    System.out.println(result);
                } catch (MaxInput e) {
                    System.out.println(e.toString());
                }
            } else if (ch == '*') {
                if (a > 7000 || b > 7000) {
                    try {
                        throw new MaxMultiplier();
                    } catch (MaxMultiplier e) {
                        System.out.println(e.toString());
                    }
                } else {
                    try {
                        float result = multi(a, b);
                        System.out.println(result);
                    } catch (MaxInput e) {
                        System.out.println(e.toString());
                    }
                }
            } else if (ch == '/') {
                if (b == 0) {
                    System.out.println("Can't divide by 0");
                } else {
                    try {
                        float result = divide(a, b);
                        System.out.println(result);
                    } catch (MaxInput e) {
                        System.out.println(e.toString());
                    }
                }
            }

            System.out.println("Enter '1' to exit and '0' to continue");
            int ex = sc.nextInt();
            if (ex == 1) {
                exit();
                break;
            }
            if (ex == 0) {
                continue;
            }
        } while (!j);
    }

    public static float add(float a, float b) throws MaxInput {
        return a + b;
    }

    public static float sub(float a, float b) throws MaxInput {
        return a - b;
    }

    public static float multi(float a, float b) throws MaxInput {
        return a * b;
    }

    public static float divide(float a, float b) throws MaxInput {
        return a / b;
    }

    public static void exit() {
        System.out.println("Thank you!!");
    }

}

class InvalidInput extends Exception {
    @Override
    public String toString() {
        return "Enter the correct operator";
    }
}

class MaxInput extends Exception {
    @Override
    public String toString() {
        return "Enter the numbers lower than 100000";
    }
}

class MaxMultiplier extends Exception {
    @Override
    public String toString() {
        return "For multiplication please enter numbers less than 7000";
    }
}

class exit {
    public void ex() {
        System.out.println("Thank you!");
    }
}
