package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine(); //"D://2.txt";//=
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(fileName1));
        boolean digit = false;
        String result = "";

        while (br.ready())
        {
            String line = br.readLine();
            String[] str = line.split(" ");
            for (String s : str)
            {
                for (int i = 0; i < s.length(); i++)
                {
                    if (s.charAt(i) >= 48 && s.charAt(i) <= 57)
                    {
                        digit = true;
                    } else
                    {
                        digit = false;
                        break;
                    }
                }
                if (digit) result = result + s+" ";
            }

        }
        br.close();
        FileWriter writeFile = new FileWriter(new File(fileName2));
        writeFile.write(result);
        writeFile.close();

    }
}



