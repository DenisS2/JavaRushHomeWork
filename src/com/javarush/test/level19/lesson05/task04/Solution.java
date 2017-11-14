package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine(); //"D://2.txt";//=
        reader.close();
        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);

        while (fileReader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = fileReader.read(); //читаем один символ (char будет расширен до int)
            if (data==46)data=33;
            fileWriter.write(data); //пишем один символ (int будет обрезан/сужен до char)
        }

        //закрываем потоки после использования
        fileReader.close();
        fileWriter.close();
    }
}



