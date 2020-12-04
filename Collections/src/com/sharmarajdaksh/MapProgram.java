package com.sharmarajdaksh;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "This language");
        languages.put("Python", "Another language");
        languages.put("Lisp", "Weird language"); // returns null because new entry
        languages.put("Java", "Overwritten"); // returns the overwritten value "This language"

        if (languages.containsKey("Java")) {
            System.out.println("Java exists in the map");
        }

        languages.putIfAbsent("Java", "Jave java"); // Will not put as "Java" key is already present

        System.out.println(languages.get("Java"));

        for (String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

        languages.remove("Lisp"); // Returns true/false to indicate if key was actually removed
        languages.remove("Python", "Weird language");

        languages.replace("Java", "Overwritten yet again"); // Overwrite value without checking Key
        languages.replace("Java", "Overwritten yet again", "YET AGAIN OVERWRTITTEN!");
    }
}
