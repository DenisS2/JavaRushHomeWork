package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        HashMap<String, Integer> mouth = new HashMap<String, Integer >();
        mouth.put("January", 1);
        mouth.put("February", 2);
        mouth.put("March", 3);
        mouth.put("April", 4);
        mouth.put("May", 5);
        mouth.put("June", 6);
        mouth.put("July", 7);
        mouth.put("August", 8);
        mouth.put("September", 9);
        mouth.put("October", 10);
        mouth.put("November", 11);
        mouth.put("December", 12);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        System.out.println(s+" is "+ mouth.get(s) + " month");

    }

}
