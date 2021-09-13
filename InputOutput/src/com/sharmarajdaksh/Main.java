package com.sharmarajdaksh;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // One way to handle file writing
        //
        // NOTE: Since throws IOException is specified
        // The catch blocks for handling the IOExceptions are unnecessary
        FileWriter locFile = null;
        try {
            locFile = new FileWriter("test.txt");
            locFile.write("This is a test write.\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (locFile != null) {
                    locFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Alternative method: try with resources
        //
        try (FileWriter locFile1 = new FileWriter("test1.txt")) {
            locFile1.write("This is another test write.\n");
            // Automatically calls close on locFile1
        }

        // Difference between methods:
        // try-finally version throws the exception on close as well as the one on open
        // The try-with block suppresses exceptions in the (hidden) close call

        try (FileWriter locFile2 = new FileWriter("test2.txt");
             FileWriter dirFile2 = new FileWriter("dest2.txt")) {
            // Multiple resources can be specified in try-with

            locFile2.write("Yet,another,test,write.");
            dirFile2.write("Yet another test write.");
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("test2.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                String w1 = scanner.next(); // Yet
                scanner.skip(scanner.delimiter());
                String w2 = scanner.next(); // another
                scanner.skip(scanner.delimiter());
                String w3 = scanner.next(); // test
                scanner.skip(scanner.delimiter());
                String w4 = scanner.next(); // write
                System.out.println(w1 + w2 + w3 + w4);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        // Performance-wise, buffered readers and writers are preferable

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("test2.txt")));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
//                String w1 = scanner.next(); // Yet
//                scanner.skip(scanner.delimiter());
//                String w2 = scanner.next(); // another
//                scanner.skip(scanner.delimiter());
//                String w3 = scanner.next(); // test
//                scanner.skip(scanner.delimiter());
//                String w4 = scanner.next(); // write
                String l = scanner.nextLine();
                String[] data = l.split(",");
                String w1 = data[0];
                String w2 = data[1];
                String w3 = data[2];
                String w4 = data[3];
                System.out.println(w1 + w2 + w3 + w4);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("test3.txt"));
            bw.write("Hello, world!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Byte streams are for reading and writing raw bytes

        try {
            DataOutputStream testFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("test3.dat")));
            testFile.writeInt(32);
            testFile.writeUTF("hello, world, this is a test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream testFile = new DataInputStream(new BufferedInputStream(new FileInputStream("test3.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    int testInt = testFile.readInt();
                    String testString = testFile.readUTF();
                    System.out.println(testInt);
                    System.out.println(testString);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        }

        // Objects can be written or read via Object streams
        //
        // Classes that need to be serialized must implement `Serializable`
        // Further, serializable objects are recommended to have a SerialVersionUID attribute,
        // which should ideally be private.

        class MyClass implements Serializable {
            // Ideally, all fields of a serializable object must be serializable as well
            private long serialVersionUID = 1L;
            private final String data;

            MyClass(String data) {
                this.data = data;
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("objtest1.dat")))) {
            MyClass mc1 = new MyClass("Hello");
            MyClass mc2 = new MyClass("Hellyo");
            oos.writeObject(mc1);
            oos.writeObject(mc2);
        }

        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("objtest1.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    MyClass mc1 = (MyClass) ois.readObject();
                    System.out.println(mc1.data);
                } catch (IOException e) {
                    eof = true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
