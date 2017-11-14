package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String fileName1 =br.readLine();
        String fileName2 =br.readLine();//"D://2.txt";//=
        br.close();

        FileReader reader = new FileReader(fileName1);
        FileWriter writer = new FileWriter(fileName2);

        char [] data= new char[1000];

        while (reader.ready())
        {
            int count = reader.read(data);
            for (int i = 0; i <count ; i++)
            {
                if (i%2!=0) writer.write(data[i]);
            }
        }
        reader.close();
        writer.close();
    }
}
