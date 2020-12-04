package com.sharmarajdaksh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] myIntArray = new int[10];
        int[] mySecondIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        for (int i = 0; i < myIntArray.length; i++) {
            myIntArray[i] = i;
        }
        myIntArray[2] = 10;

        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        myArrayList.add(5);
        myArrayList.set(0, 9); // position, value
        boolean hasNine = myArrayList.contains(9);
        int positionOfNone = myArrayList.indexOf(9);
        myArrayList.remove(0);

        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        myLinkedList.add(2);
        myLinkedList.add(5);
        myLinkedList.add(3);

        // Iteration
        Iterator<Integer> i = myLinkedList.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }

    }
}
