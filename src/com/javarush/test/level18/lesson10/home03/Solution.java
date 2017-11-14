package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        String fileName3 = scanner.nextLine();
        scanner.close();
        FileInputStream input2 = new FileInputStream(fileName2);
        FileInputStream input3 = new FileInputStream(fileName3);
        FileOutputStream output1 = new FileOutputStream(fileName1);
        if (input2.available()>0)
        {
            byte[] buffer = new byte[input2.available()];
            int count=input2.read(buffer);
            output1.write(buffer);
            input2.close();
        }

        if (input3.available()>0)
        {
            byte[] buffer = new byte[input3.available()];
            int count=input3.read(buffer);
            output1.write(buffer);
            input3.close();
        }
        output1.close();
    }
}
