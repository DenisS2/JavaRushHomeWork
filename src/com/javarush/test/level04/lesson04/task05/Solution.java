package com.javarush.test.level04.lesson04.task05;

/* Положительное и отрицательное число
Ввести с клавиатуры число. Если число положительное, то увеличить его в два раза. Если число отрицательное, то прибавить единицу.
Вывести результат на экран.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int n = (int)reader.read();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n =  sc.nextInt();
        if (n>0) System.out.println(n*2);
        if (n<0) System.out.println(n+1);


    }

}