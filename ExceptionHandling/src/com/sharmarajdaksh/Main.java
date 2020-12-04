package com.sharmarajdaksh;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// int x = 59;
// int y = 0;
// System.out.println(divieEAFP(x, y));
// System.out.println(diveideLBYL(x, y));
// int x = getIntLBYL();

        int x = getIntEAFP();
        System.out.println(x);

    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer: ");
        String input = s.next();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }

        return isValid ? Integer.parseInt(input) : 0;
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        try {
            return s.nextInt();
        } catch(InputMismatchException e) {
            return 0;
        }
    }

    private static int diveideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divieEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
