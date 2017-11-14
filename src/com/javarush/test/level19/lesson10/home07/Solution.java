package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        FileWriter writeFile = new FileWriter(new File(args[1]));
        String result = "";
        while (fileReader.ready())
        {
            String line = fileReader.readLine();
            String[] strings = line.split(" ");
            for (int i = 0; i < strings.length; i++)
            {
                if (strings[i].length() > 6)
                {
                    result = result + strings[i] + ",";
                }

            }
        }
            //result=result.substring(result.length()-1);
            writeFile.write(result.substring(0,result.length()-1));
            fileReader.close();
            writeFile.close();
    }
}
