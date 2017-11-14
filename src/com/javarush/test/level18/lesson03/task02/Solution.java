package com.javarush.test.level18.lesson03.task02;

import java.io.FileInputStream;
import java.util.Scanner;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName =scanner.nextLine();
        int min=128;
        FileInputStream input = new FileInputStream(fileName);
        while (input.available()>0){
            int bytee=input.read();
            if (bytee<min) min=bytee;
        }
        System.out.println(min);
        input.close();
    }
}
