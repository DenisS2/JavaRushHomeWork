package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream file =new FileInputStream(args[0]);
        //int[] alphabet = new int[52];
        int letterSum=0;
        //int j=65;
        //for(char i = 0;i<52;i++)
        //{
        //    alphabet[i]=j;
        //    if (j==90) j=96;
        //    j++;
        //}

        while (file.available()>0){
            int simbol=file.read();
            if((simbol >= 65 && simbol <= 90) || (simbol >=97 && simbol <= 122)) letterSum++;
            //for (int i = 0; i <alphabet.length-1 ; i++)
            //{
            //    if (simbol==alphabet[i]) letterSum++;
            //}
        }
        System.out.println(letterSum);
        file.close();
    }
}

