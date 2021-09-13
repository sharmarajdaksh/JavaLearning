package com.sharmarajdaksh;

// java.io is blocking
// The newer, java.nio works in a non-blocking fashion
// java.io deals with data as streams (characters and binary)
// java.nio deals with data in blocks, using channels and buffers


import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {


    private static class MyClass {
        int myInt;
    }

    // nio works with Path objects rather than File objects
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("test.txt");
        try (BufferedWriter pathFile = Files.newBufferedWriter(path)) {
            pathFile.write("Hello, world!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Reading and writing objects
        MyClass mc = new MyClass();
        Path path2 = FileSystems.getDefault().getPath("test2.txt");
        try (ObjectOutputStream o2 = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(path2)))) {
           o2.writeObject(mc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream o2 = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(path2)))) {
            MyClass mc2 = (MyClass) o2.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
