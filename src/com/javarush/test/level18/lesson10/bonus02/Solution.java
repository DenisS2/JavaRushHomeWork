package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла,
генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/



import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception
    {
        switch (args[0])
        {
            case "-c":
            {
                add(args);
                break;
            }
            default:
            {
                System.out.println("Неправильный параметр " + args[0]);
                break;
            }
        }
    }


    static void add(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        //ArrayList<String> file = new ArrayList<String>();  "D://2.txt";//=
        Scanner input = new Scanner (new File(fileName));
        int max=0;
        int id=0;
        String line="";
        while (input.hasNextLine())
        {
            line = input.nextLine();
            if (!line.equals(""))
                id = Integer.parseInt(line.substring(0, 8).trim());
            if (id>max)max=id;
            //file.add(line);
        }
        input.close();

        max++;
        String result=""+max;
        for (int i = 0; i <8 ; i++)
        {
            if (i==result.length())result=result+" ";
        }
        result=result+args[1];
        for (int i = 0; i <38 ; i++)
        {
            if (i==result.length())result=result+" ";
        }
        result=result+args[2];
        for (int i = 0; i <46 ; i++)
        {
            if (i==result.length())result=result+" ";
        }
        result=result+args[3];
        for (int i = 0; i <50 ; i++)
        {
            if (i==result.length())result=result+" ";
        }
        FileWriter writeFile = new FileWriter(new File(fileName), true);
        if (line.charAt(line.length()-1)!='\n')  writeFile.write("\n");
            //int size=file.size();
            //file.add(size,result);

            writeFile.write(result);
            writeFile.close();
    }

}
