package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
//d://3/1.txt.part1
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> fileNames=new ArrayList<String>();
        String fileName = scanner.nextLine();
        while (!fileName.equals("end"))
        {
            fileNames.add(fileName);
            fileName = scanner.nextLine();
        }
        scanner.close();
        fileName=fileNames.get(0);
        String[] path=fileName.split(".part");
        File newFile=new File(path[0]);
        newFile.createNewFile();
        FileOutputStream output = new FileOutputStream(path[0]);
        Collections.sort(fileNames);
        for (String s:fileNames)
        {
            FileInputStream input = new FileInputStream(s);
            byte[] buffer=new byte[input.available()];
            input.read(buffer);
            output.write(buffer);
            input.close();
        }
        output.close();
    }
}
