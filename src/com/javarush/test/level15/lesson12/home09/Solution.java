package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        String s= reader.readLine();
        int posEnd=0;
        boolean f=false;
        String parametr;
        int posStart=s.indexOf("?");
        s=s.substring(posStart+1);
        while (s.contains("&"))
        {
            posEnd=s.indexOf("=");
            posStart=s.indexOf("&");
            if (posEnd>posStart) parametr=s.substring(0,posStart);
            else parametr=s.substring(0, posEnd);
            System.out.print(parametr+" ");
            if (parametr.equals("obj")) {
                f=true;
                list.add(s.substring(posEnd+1,s.indexOf("&")));
            }
            posStart = s.indexOf("&");
            s=s.substring(posStart+1);
        }
        posEnd=s.indexOf("=");
        if (posEnd==-1)
        System.out.println(s);
        else{
            System.out.println(s.substring(0,posEnd));

        if (s.substring(0,posEnd).equals("obj"))
        {
            f = true;
            list.add(s.substring(posEnd + 1, s.length()));
        }
        }
            if (f)
            {
                for (String obj:list)
                {
                    try
                    {
                        alert(Double.parseDouble(obj));
                    }
                    catch (Exception e)
                    {
                        alert(obj);
                    }
                }
            }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
