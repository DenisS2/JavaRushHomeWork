package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream input = new FileInputStream(fileName);
        scanner.close();
        if (input.available()>0)
        {
            byte[] buffer = new byte[input.available()];
            int count = 0;
            input.read(buffer);
            input.close();
            for (int i:buffer)
            {
                if (i==44) count++;
            }
            System.out.println(count);
        }
    }
}