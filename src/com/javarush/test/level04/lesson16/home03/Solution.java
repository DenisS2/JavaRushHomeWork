package com.javarush.test.level04.lesson16.home03;

import java.io.*;
import java.util.Scanner;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {int sum=0;
     boolean i=true;
        Scanner sc = new Scanner(System.in);
        while(i)
        {
            int a = sc.nextInt();
            if(a==-1)
            {
                sum = sum + a;
                System.out.println(sum);
                i=false;
            }
            else sum=sum+a;
        }
    }
}
