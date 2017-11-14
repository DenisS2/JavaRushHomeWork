package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {

        ArrayList<Integer> digit = new ArrayList<Integer>();
        ArrayList<Integer> letter = new ArrayList<Integer>();

        for (int i=0; i<array.length; i++)
            if (isNumber(array[i])) digit.add(i);
            else letter.add(i);

        for (int i = 0; i <letter.size() ; i++)
        {
            for (int j = letter.get(0); j <letter.size()-1 ; j++)
            {
                if (isGreaterThan(array[letter.get(j)], array[letter.get(j+1)]))
                {
                    String temp=array[letter.get(j)];
                    array[letter.get(j)]=array[letter.get(j+1)];
                    array[letter.get(j+1)]=temp;
                }
            }
        }

        for (int i = 0; i <digit.size() ; i++)
        {
            for (int j = digit.get(0); j <digit.size()-1 ; j++)
            {
                    if (Integer.parseInt(array[digit.get(j)])<Integer.parseInt(array[digit.get(j+1)])){
                    String temp=array[digit.get(j)];
                    array[digit.get(j)]=array[digit.get(j+1)];
                    array[digit.get(j+1)]=temp;
                    }
            }
        }





        /*String tempString;
        for (int i = 0; i < array.length; i++) {
            if (!isNumber(array[i])){
                for (int j = i+1; j < array.length; j++) {
                    if (!isNumber(array[j])){
                        if (isGreaterThan(array[i], array[j])){
                            tempString = array[i];
                            array[i] = array[j];
                            array[j] = tempString;
                        }
                    }
                }
            }
        }
        String tempNumber;
        for (int i = array.length-1; i >= 0; i--) {
            if (isNumber(array[i]))
            {
                for (int j = i - 1; j >= 0; j--)
                {
                    if (isNumber(array[j]))
                    {
                        if (Integer.parseInt(array[i])>Integer.parseInt(array[j]))
                        {
                            tempNumber = array[i];
                            array[i] = array[j];
                            array[j] = tempNumber;
                        }
                    }
                }
            }    }*/
    }



    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;

    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
