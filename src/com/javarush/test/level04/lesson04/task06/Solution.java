package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       /* Scanner scaner = new Scanner(System.in);
        int day=scaner.nextInt();
        switch (day){
            case 1: System.out.println("Понедельник");
                break;
            case 2: System.out.println("Вторник");
                break;
            case 3: System.out.println("Среда");
                break;
            case 4: System.out.println("Четверг");
                break;
            case 5: System.out.println("Пятница");
                break;
            case 6: System.out.println("Суббота");
                break;
            case 7: System.out.println("Воскресенье");
                break;
                default: System.out.println("такого дня недели не существует");*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String vvod = reader.readLine();
        int a = Integer.parseInt(vvod);
        if (a<=7&&a>0&&a!=0){
            if(a==1)
                System.out.println("понедельник");
            else if(a==2)
                System.out.println("вторник");
            else if(a==3)
                System.out.println("среда");
            else if(a==4)
                System.out.println("четверг");
            else if(a==5)
                System.out.println("пятница");
            else if(a==6)
                System.out.println("суббота");
            else if(a==7)
                System.out.println("воскресенье");
        }
        else {
            System.out.println("такого дня недели не существует");
        }


        //напишите тут ваш код

    }

}