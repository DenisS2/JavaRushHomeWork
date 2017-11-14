package com.javarush.test.level17.lesson10.home09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        Scanner scaner = new Scanner(System.in);
        String filename1=scaner.nextLine();
        String filename2=scaner.nextLine();
        try
        {
            Scanner fileReader = new Scanner(new File(filename1));
            while (fileReader.hasNextLine()) {
                allLines.add(fileReader.nextLine());
            }
            fileReader.close();

            Scanner fileReader1 = new Scanner(new File(filename2));
            while (fileReader1.hasNextLine()) {
                forRemoveLines.add(fileReader1.nextLine());
            }
            fileReader1.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Неправильное имя файла");
        }
        Solution solution = new Solution();
        try
        {
            solution.joinData();
        }
        catch (CorruptedDataException e)
        {
            e.printStackTrace();
        }
        System.out.println(allLines);
        System.out.println(forRemoveLines);
    }

    public void joinData () throws CorruptedDataException {
        //boolean f=false;
        //boolean vse=true;
        int kol=0;
        for (String str:forRemoveLines)
        {
            //f=false;
            for (String s:allLines)
            {
                if(str.equals(s)){
                    kol++;
                    //f=true;
                    break;
                }
            }
        }
        if(kol==forRemoveLines.size()){
            for (String str:forRemoveLines)
            {
                for (int i = allLines.size()-1; i >=0 ; i--)
                {
                    if(str.equals(allLines.get(i))){
                        allLines.remove(i);
                    }
                }
            }

        }
        else
        {
            allLines.clear();
            throw  new CorruptedDataException();
        }
    }
}
