package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту
properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

   /* public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
    }*/


    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine(); //"d://2.txt"
        br.close();

        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        inputStream.close();
        //OutputStream outputStream = new FileOutputStream(fileName);
        //save(outputStream);
        //outputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propertiesMap = new Properties();
        for (Map.Entry<String, String> map:properties.entrySet())
        {
            propertiesMap.put(map.getKey(), map.getValue());
        }
        propertiesMap.store(outputStream,null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propertiesMap = new Properties();
        propertiesMap.load(inputStream);
        for (Map.Entry<Object, Object> prMap :propertiesMap.entrySet())
        {
            properties.put(prMap.getKey().toString(),prMap.getValue().toString());
        }
    }
}
