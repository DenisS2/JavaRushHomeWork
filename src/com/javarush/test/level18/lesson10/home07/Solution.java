package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде,
в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception
    {

        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        scanner.close();
        ArrayList<String> list =new ArrayList<String>();
        Scanner fileRead = new Scanner (new File (fileName1));
        while (fileRead.hasNextLine()) {
            list.add(fileRead.nextLine());
        }
        fileRead.close();
        for (String s:list)
        {
            String[] ss=s.split(" ");
            if (ss[0].equals(args[0])) System.out.println(s);
        }
    }
}
