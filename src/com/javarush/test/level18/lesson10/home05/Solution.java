package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

import java.util.Scanner;

import static java.lang.StrictMath.round;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        scanner.close();
        Scanner readFile = new Scanner (new File (fileName1));
        String line = readFile.nextLine();
        readFile.close();
        String result="";
        String str[]=line.split(" ");
        for (String  s:str)
        {
            double d=Double.parseDouble(s);
            long i= round(d);
            result=result+i+" ";
        }
        int[] buferInt = new int[result.length()];
        FileOutputStream output = new FileOutputStream(fileName2);
        for (int i = 0; i < result.length(); i++)
        {
            buferInt[i]=result.charAt(i);
            output.write(buferInt[i]);
        }
        output.close();
    }
}
