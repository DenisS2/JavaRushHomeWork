package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        HashMap<String, Double> treeMap = new HashMap<>();
        while (fileReader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            String line = fileReader.readLine();
            String[] str = line.split(" ");
            try
            {
                treeMap.put(str[0], treeMap.get(str[0]) + Double.parseDouble(str[1]));
            }
            catch (NullPointerException e){
                treeMap.put(str[0], Double.parseDouble(str[1]));
            }
        }
        fileReader.close();
        Double max=0.0;
        for (Map.Entry<String,Double> entry:treeMap.entrySet())
        {
            if (max<entry.getValue())max=entry.getValue();
        }
        for (Map.Entry<String,Double> entry:treeMap.entrySet())
        {
            if (entry.getValue().equals(max))
                System.out.println(entry.getKey());
        }
    }
}
