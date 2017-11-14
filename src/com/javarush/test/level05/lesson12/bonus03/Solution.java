package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int maximum =max(mas);  ;

        int n=Integer.parseInt(reader.readLine());

        int[] mas= new int[n];
        for (int i = 0; i < n; i++)
        {
            mas[i] = Integer.parseInt(reader.readLine());
        }
        int maximum =max(mas, n);

        //int minimum = max(mas);

        System.out.println(maximum);
    }


    public static int max (int[]mas,int n)
    {
        int max=mas[0];
        for (int i = 0; i < n; i++)
        {
            if (max<mas[i]) max=mas[i];
        }
        return max;
    }



       // System.out.println(maximum);
}

