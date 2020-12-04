package com.sharmarajdaksh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

//        // Shallow copy (References the same objects)
//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//
//        // Reverses the seatCopy object, and hence the original theatre.seats
//        Collections.reverse(seatCopy);
//
//        // Max and min in a collection
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//
//        // Custom sort method
//        sortList(seatCopy);
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
