package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String fileName3 = scanner.nextLine();
        scanner.close();
        FileInputStream input = new FileInputStream(fileName1);
        FileOutputStream output1 = new FileOutputStream(fileName2);
        FileOutputStream output2 = new FileOutputStream(fileName3);
        if (input.available()>0)
        {
            byte[] buffer = new byte[input.available()];
            int count=buffer.length;
            input.read(buffer);
            input.close();
            if (count%2==0) count=count/2;
            else count=count/2+1;
            output1.write(buffer, 0, count);
            output2.write(buffer, count, buffer.length-count);
            output1.close();
            output2.close();
        }
    }
}