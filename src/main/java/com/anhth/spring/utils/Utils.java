package com.anhth.spring.utils;

public class Utils {
    public static Integer parseInteger(String input, Integer defaultValue) {
        Integer output = defaultValue;
        try {
            output = Integer.parseInt(input);
        } catch (Exception e) {
        }
        return output;
    }
}
