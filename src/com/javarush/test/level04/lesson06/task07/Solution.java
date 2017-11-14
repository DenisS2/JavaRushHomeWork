package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        int[] number=new int[3];
        for (int i = 0; i < 3; i++)
        {
            number[i] = sc.nextInt();
        }
        if(number[0]==number[1]) System.out.println("3");
        if(number[0]==number[2]) System.out.println("2");
        if(number[1]==number[2]) System.out.println("1");


    }
}
