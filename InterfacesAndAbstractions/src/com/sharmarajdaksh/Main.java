package com.sharmarajdaksh;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ITelephone myPhone;

        // Valid
        myPhone = new MobilePhone();
        // Also Valid
        myPhone = new DeskPhone();
    }
}
