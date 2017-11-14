package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //"D://2.txt";//=
        reader.close();
        int world=0;
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while (br.ready())
        {
            String line = br.readLine();
            String[] wolds=line.split("\\p{Punct}+");
            for (String s:wolds)
            {
                String[] wolds1=s.split(" ");
                for (String r:wolds1)
                {
                    if (r.equals("world")) world++;
                }
            }
        }
        br.close();
        System.out.println(world);
    }
}
