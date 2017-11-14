package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileOutputStream outStream = new FileOutputStream(fileName);
        while (true)
        {
            String s=reader.readLine();
            s=s+"\r\n";
            for (int i=0; i<s.length(); i++)
            {
                outStream.write(s.charAt(i));
            }
            if (s.equals("exit\r\n")) break;
        }
        outStream.close();
        reader.close();
    }
}
