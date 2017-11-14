package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        switch (args[0])
        {
            case "-u":
            {
                update(args);
                break;
            }
            case "-d":
            {
                delete(args);
                break;
            }
            default:
            {
                System.out.println("Неправильный параметр " + args[0]);
                break;
            }
        }
    }


    static void update(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName =  scanner.nextLine();    //"D://2.txt";//=
        scanner.close();
        ArrayList<String> file = new ArrayList<String>();
        Scanner input = new Scanner(new File(fileName));
        String id = "";
        String line = "";
        int j=0;
        int pos=-1;
        while (input.hasNextLine())
        {
            line = input.nextLine();
            if (!line.equals(""))
                //id = Integer.parseInt(line.substring(0, 8).trim());
                id=line.substring(0, 8).trim();
            file.add(j,line);
            if (args[1].equals(id))pos=j;
            j++;
        }
        input.close();

        if (pos<0){
            System.out.println("id не найден");
            return;
        }
        String productName=args[2];
        if (args.length-3!=2)
        for (int i = 3; i <args.length-2 ; i++)
        {
            productName=productName+" "+args[i];
        }

        String result=""+args[1];
        for (int i = 0; i <8 ; i++)
        {
            if (i==result.length())result=result+" ";
        }
        result=result+productName;
        for (int i = 0; i <38 ; i++)
        {
            if (i==result.length())result=result+" ";
        }
        result=result+args[args.length-2];
        for (int i = 0; i <46 ; i++)
        {
            if (i==result.length())result=result+" ";
        }
        result=result+args[args.length-1];
        for (int i = 0; i <50 ; i++)
        {
            if (i==result.length())result=result+" ";
        }
        file.set(pos,result);
        FileWriter writeFile = new FileWriter(new File(fileName));
        for (String s:file)
        {
            writeFile.write(s+"\n");
        }
        writeFile.close();
        //System.out.println(result);
    }

    static void delete(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String fileName =  scanner.nextLine(); //"D://2.txt";//=
        scanner.close();
        ArrayList<String> file = new ArrayList<String>();
        Scanner input = new Scanner(new File(fileName));
        String id = "";
        String line = "";
        int j=0;
        int pos=-1;
        while (input.hasNextLine())
        {
            line = input.nextLine();
            if (!line.equals(""))
                //id = Integer.parseInt(line.substring(0, 8).trim());
                id=line.substring(0, 8).trim();
            file.add(j,line);
            if (args[1].equals(id))pos=j;
            j++;
        }
        input.close();
        if (pos>=0)file.remove(pos);

        FileWriter writeFile = new FileWriter(new File(fileName));
        for (String s:file)
        {
            writeFile.write(s+"\n");
        }
        writeFile.close();
    }
}

