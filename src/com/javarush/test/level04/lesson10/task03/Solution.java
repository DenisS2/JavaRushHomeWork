package com.javarush.test.level04.lesson10.task03;

import java.io.*;
import java.util.Scanner;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        while (n>0) {
            System.out.println(str);
            n--;
        }

    }
}
