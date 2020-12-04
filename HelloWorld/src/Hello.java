import java.util.Scanner;

public class Hello {
    private static void printIt(String s) {
        System.out.println(s);
    }

    // Overloaded method
    private static void printIt() {
        System.out.println("printIt without any arguments!");
    }

    public static void main(String[] args) {

        System.out.println("Hello World");

        //      Primitive Types
        //          boolean
        //          byte
        //          char
        //          short
        //          int
        //          long
        //          float
        //          double

        int myFirstNumber = 5;
        long myLong = 100L;
        short myShort = 100;

        boolean myBool = true;

        char myChar = 'c';

        //      Doubles are default fractional numbers
        float myFloat = 1.2F;
        double myDouble = 1.23D;

        //      Type Casting
        byte myNewByte = (byte) myShort;
        short myNewShort = (short) myFirstNumber;

        //      String
        String myString = "Hello World";
        String myAppendedString = myString + " Appended";

        //      Operators
        myLong++;
        myShort--;
        myLong += 2;
        myFloat /= 2;

        // if-else
        boolean isAlien = false;
        if (!isAlien) {
            System.out.println("Not an alien");
        } else {
            System.out.println("Alien");
        }

        // &&, ||, <=, etc are all C-like
        // &, | are bitwise operators

        boolean isAlienTwo = isAlien ? true : false;

        printIt("Wow!");
        printIt();

        int someRandomValue = 9;
        switch (someRandomValue) {
            case 6:
                printIt();
                break;
            case 9:
                printIt(Integer.toString(9));
                break;
            default:
                printIt(Integer.toString(someRandomValue));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int c = 0;
        while(c < 5) {
            System.out.println(c);
            c++;
        }

        do {
            System.out.println(c);
            c++;
        } while(c < 10);

        // Reading user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me your name?");
        String name = scanner.nextLine();
        int age;
        // Check that there is a next Int input
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
        } else {
            age = -1;
        }
        scanner.close();
        System.out.println("You are " + name + " and you are " + age + " years old");
    }
}
