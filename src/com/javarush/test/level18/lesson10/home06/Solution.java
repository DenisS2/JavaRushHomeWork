package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        FileInputStream input = new FileInputStream(args[0]);
        byte[] buffer = new byte[input.available()];
        if (input.available()>0)
        {
            input.read(buffer);
        }
        input.close();
        TreeMap<Byte, Integer> map = new TreeMap<Byte, Integer>();
        for (Byte i:buffer)
        {
            int count=0;
            for (int j = 0; j < buffer.length; j++)
            {
                if (i==buffer[j]) count++;
            }
            map.put(i,count);
        }
        for( Map.Entry<Byte,Integer> entry : map.entrySet()) {
            //получить ключ
            byte key = entry.getKey();
            //получить значение
            Integer value = entry.getValue();
            System.out.println((char) key+ " "+ value);
        }
    }
}
