package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
       boolean f = isDateOdd("JANUARY 2 2000");
       System.out.println(f);
    }

    public static boolean isDateOdd(String date)
    {
        Date today = new Date(date);

        int year = today.getYear()-1;
        year=year+1900;
        String newYear = "DECEMBER 31 "+ Integer.toString(year);
        Date newYearDate = new Date(newYear);
        long time = today.getTime()-newYearDate.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = (int)(time/msDay);
        if (dayCount%2==0) return false;
        else return true;
    }
}
