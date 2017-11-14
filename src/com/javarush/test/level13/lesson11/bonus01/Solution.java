package com.javarush.test.level13.lesson11.bonus01;

/*Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream inStream = new FileInputStream(fileName);
        ArrayList<Integer> listInteger= new ArrayList<>();
        ArrayList<String> listString = new ArrayList<>();
        String s="";
        while (inStream.available()>0)
        {
            int simbol=inStream.read();
            if (simbol!=13)
                if (simbol!=10)
                    s=s+(char)simbol;
            else
            {
                listString.add(s);
                s="";
            }
        }
        listString.add(s);
        for (String a:listString)
        {
            int i=Integer.parseInt(a);
            if (i%2==0) listInteger.add(i);
        }
        Collections.sort(listInteger);
        for (int i:listInteger)
        {
            System.out.println(i);
        }
        inStream.close();
        reader.close();

    }
}