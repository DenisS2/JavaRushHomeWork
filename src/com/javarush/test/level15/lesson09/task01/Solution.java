package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(10.1,"10");
        labels.put(20.3,"20");
        labels.put(30.3,"30");
        labels.put(40.4,"40");
        labels.put(50.5,"50");
    }


    public static void main(String[] args) {

        System.out.println(labels);
    }
}
