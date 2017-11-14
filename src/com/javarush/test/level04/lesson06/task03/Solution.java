package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        if(a<b) {int temp=a;
        a=b;
        b=temp;}
        if(a<c) {int temp=a;
            a=c;
            c=temp;}
        if(b<c) {int temp=b;
            b=c;
            c=temp;}
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        //напишите тут ваш код

    }
}
