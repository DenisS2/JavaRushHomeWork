package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
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
        scanner.close();
        FileInputStream input1 = new FileInputStream(fileName1);
        FileInputStream input2 = new FileInputStream(fileName2);

        byte[] buffer1 = new byte[input1.available()];
        byte[] buffer2 = new byte[input2.available()];
        if (input1.available()>0)
        {
            input1.read(buffer1);
        }
        input1.close();
        if (input2.available()>0)
        {
            input2.read(buffer2);
        }
        input2.close();
        FileOutputStream output1 = new FileOutputStream(fileName1);
        output1.write(buffer2);
        output1.write(buffer1);
        output1.close();
    }
}
