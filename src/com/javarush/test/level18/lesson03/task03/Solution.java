package com.javarush.test.level18.lesson03.task03;



import java.io.FileInputStream;
import java.util.*;



/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName =scanner.nextLine();
        FileInputStream input = new FileInputStream(fileName);
        ArrayList<Integer> file = new ArrayList();
        HashMap <Integer, Integer> map= new HashMap<Integer,Integer>();
        while (input.available()>0){
            file.add(input.read());
        }
        input.close();

        for (int i:file)
        {
            int count=0;
            for (int j = 0; j < file.size()-1; j++)
            {
                if (i==file.get(j)) count++;
            }
                map.put(i, count);
        }
        //System.out.println(map);
        //http://info.javarush.ru/translation/2014/02/11/9-главных-вопросов-о-Map-в-Java.html
        int maxValue=0;
        for( Map.Entry<Integer,Integer> n : map.entrySet()) {
            //получить ключ
            //Integer key = n.getKey();
            //получить значение
            Integer value = n.getValue();
            if (value>maxValue) maxValue=value;
        }
        for( Map.Entry<Integer,Integer> n : map.entrySet()) {
            //получить ключ
            Integer key = n.getKey();
            //получить значение
            Integer value = n.getValue();
            if (value==maxValue) System.out.print(key+ " ");
        }
    }
}



