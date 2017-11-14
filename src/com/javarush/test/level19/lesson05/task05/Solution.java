package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        FileWriter writeFile = new FileWriter(new File(fileName2));

        while (fileReader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            String line = fileReader.readLine();
            String[] wolds=line.split("\\p{Punct}+");
            line="";
            for (String s:wolds)
            {
                line=line+s;
            }
            writeFile.write(line);
        }
        //закрываем потоки после использования
        fileReader.close();
        writeFile.close();
    }
}

