package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        scanner.close();
        FileInputStream input = new FileInputStream(fileName1);
        FileOutputStream output = new FileOutputStream(fileName2);
        if (input.available()>0)
        {
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            input.close();
            for (int i = buffer.length-1; i >=0 ; i--)
            {
               output.write(buffer[i]);
            }
            output.close();
        }
    }
}