package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;


/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз,
 и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    volatile public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        while (!fileName.equals("exit"))
        {
            new ReadThread(fileName).start();
            fileName = scanner.nextLine();
        }
        scanner.close();
    }

    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName)
        {
            //implement constructor body
            this.fileName = fileName;
            //start();
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run()
        {
            ArrayList<Integer> file = new ArrayList();
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            try
            {
                FileInputStream input = new FileInputStream(fileName);
                while (input.available() > 0)
                {
                    file.add(input.read());
                }
                input.close();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
            for (int i : file)
            {
                int count = 0;
                for (int j = 0; j < file.size(); j++)
                {
                    if (i == file.get(j)) count++;
                }
                map.put(i, count);
            }
            runMapResult(map);
        }

        public synchronized void runMapResult(Map<Integer,Integer> map){
            int maxValue = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                //получить ключ
                //Integer key = n.getKey();
                //получить значение
                Integer value = entry.getValue();
                if (value > maxValue) maxValue = value;
            }



            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                //получить ключ
                Integer key = entry.getKey();
                //получить значение
                Integer value = entry.getValue();
                if (value == maxValue) {
                    resultMap.put(fileName,key);
                }
            }
            //System.out.println(resultMap);
        }
    }
}