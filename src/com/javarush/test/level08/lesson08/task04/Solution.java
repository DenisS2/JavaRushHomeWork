package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне1", new Date("JUNE 1 1980"));
        map.put("Сталлоне2", new Date("JU1 1980"));
        map.put("Сталлоне3", new Date("AUGUST 1 1980"));
        map.put("Сталлоне4", new Date("JUNE 1 1980"));
        map.put("Сталлоне5", new Date("JULY  1 1980"));
        map.put("Сталлоне6", new Date("AUGUST 1 1980"));
        map.put("Сталлоне7", new Date("JUNE 1 1980"));
        map.put("Сталлоне8", new Date("JULY  1 1980"));
        map.put("Сталлоне9", new Date("AUGUST 1 1980"));
        map.put("Сталлоне10", new Date("JUNE 1 1980"));
        return (HashMap<String, Date>)map;
    }
    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            if ( value.getMonth() > 4 & value.getMonth() < 8)
                iterator.remove();
                //map.remove(pair.getKey());
        }

    }
}