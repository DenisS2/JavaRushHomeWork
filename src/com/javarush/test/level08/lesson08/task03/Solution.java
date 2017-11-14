package com.javarush.test.level08.lesson08.task03;

import java.util.*;


/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Petr");
        map.put("Sidorov", "Sidor");
        map.put("Kuznecov", "Aleksey");
        map.put("Gusev", "Boris");
        map.put("Volkov", "Jonh");
        map.put("Zaicev", "Anufriy");
        map.put("Krolikoff", "Krolik");
        map.put("Vydrin", "Fydrey");
        map.put("Pescov", "Boris");
        return map;


    }

   /* public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int i=0;
        for (String s:map.values())
        {
        if(s==name) i++;
        }
        return i;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {//Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
      //  int i=0;
       // while (iterator.hasNext())
        //{
         //   Map.Entry<String, String> pair = iterator.next();
          //  if(lastName==pair.getKey())  i++;
           // }

        int i=0;
        for (String s:map.keySet())
        {
            if(s==lastName) i++;
        }
        return i;
    }*/
   public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
   {
       int na = 0;
       for (Map.Entry<String,String> n : map.entrySet())
           if (n.getValue().equals(name)) na++;
       return na;
   }
    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int la = 0;
        for (Map.Entry<String,String> n : map.entrySet())
            if (n.getKey().equals(lastName)) la++;
        return la;
    }
}
