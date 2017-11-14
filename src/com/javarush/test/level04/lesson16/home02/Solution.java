package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[3];
        int temp=0;
        for (int i = 0; i < 3; i++)
        {
            array[i]=sc.nextInt();
        }
        for (int i = 0; i < 2 ; i++)
        {
                if (array[i]>array[i+1]) {
                temp=array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
            }
        }
        System.out.println(array[1]);


    }
}
