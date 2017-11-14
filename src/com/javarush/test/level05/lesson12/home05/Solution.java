package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Scanner sc= new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String i=null;
        int sum=0;
        //boolean j=i=="сумма";
        do


        {
            i = reader.readLine();
            if (i.equals("сумма")) {
                System.out.println(sum);
                break;
            }

            else {
                 sum=sum+Integer.parseInt(i);
            }
        } while(i!="сумма");
        //System.out.println(sum);


    }
}
