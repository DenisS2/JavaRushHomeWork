package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        while (fileReader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            String line = fileReader.readLine();
            String[] strings=line.split(" ");
            String name="";
            for (int i = 0; i < strings.length-3; i++)
            {
                if (i==strings.length-4)name=name+strings[i];
                else name=name+strings[i]+" ";
            }
            Date date=new Date();
            date.setDate(Integer.parseInt(strings[strings.length-3]));
            date.setMonth(Integer.parseInt(strings[strings.length-2])-1);
            date.setYear(Integer.parseInt(strings[strings.length-1]));
            PEOPLE.add(new Person(name, date));
        }
        fileReader.close();
        /*for (Person p:PEOPLE)
        {
            System.out.println(p.getName());
            System.out.println(p.getBirthday());
        }*/
    }

}
