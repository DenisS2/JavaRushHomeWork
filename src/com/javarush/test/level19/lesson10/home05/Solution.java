package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        FileWriter writeFile = new FileWriter(new File(args[1]));
        while (fileReader.ready())
        {
            String line = fileReader.readLine();
            String[] strings=line.split(" ");
            for (String s:strings)
            {
                boolean b=false;
                for (int i = 0; i <s.length() ; i++)
                {
                    if (s.charAt(i)>=48&&s.charAt(i)<=57) b=true;
                }
                if (b) writeFile.write(s+" ");
            }

        }
        fileReader.close();
        writeFile.close();
    }
}
