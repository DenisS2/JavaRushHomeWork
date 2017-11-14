package com.javarush.test.level18.lesson03.task04;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            String fileName =scanner.nextLine();
            FileInputStream input = new FileInputStream(fileName);
            ArrayList<Integer> file = new ArrayList();
            HashMap<Integer, Integer> map= new HashMap<Integer,Integer>();
            while (input.available()>0){
                file.add(input.read());
            }
            input.close();
            int count=0;
            for (int i:file)
            {
                count=0;
                for (int j = 0; j < file.size()-1; j++)
                {
                    if (i==file.get(j)) count++;
                }
                map.put(i, count);
            }
        //System.out.println(map);
            //http://info.javarush.ru/translation/2014/02/11/9-главных-вопросов-о-Map-в-Java.html
            int minValue=count;
            for( Map.Entry<Integer,Integer> n : map.entrySet()) {
                //получить ключ
                //Integer key = n.getKey();
                //получить значение
                Integer value = n.getValue();
                if (value<minValue) minValue=value;
            }
            for( Map.Entry<Integer,Integer> n : map.entrySet()) {
                //получить ключ
                Integer key = n.getKey();
                //получить значение
                Integer value = n.getValue();
                if (value==minValue) System.out.print(key+ " ");
            }
        }
    }



