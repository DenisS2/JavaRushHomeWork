package com.javarush.test.level18.lesson03.task01;

import java.io.FileInputStream;
import java.util.Scanner;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName =scanner.nextLine();
        int max=0;
        FileInputStream input = new FileInputStream(fileName);
        while (input.available()>0){
            int bytee=input.read();
            if (bytee>max) max=bytee;
        }
        System.out.println(max);
        input.close();
    }
}
