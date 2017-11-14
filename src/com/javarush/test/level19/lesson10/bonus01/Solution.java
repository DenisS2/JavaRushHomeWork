package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine(); //"d://2.txt";
        br.close();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2));
        ArrayList<String> file1 = new ArrayList<String>();
        ArrayList<String> file2 = new ArrayList<String>();
        while (fileReader1.ready())
            file1.add(fileReader1.readLine());
        while (fileReader2.ready())
            file2.add(fileReader2.readLine());
        fileReader1.close();
        fileReader2.close();

        int plus;
        if (file1.size()<=file2.size())
        {
            plus = file2.size() + 1;
            for (int i = file1.size(); i <plus ; i++)
            {
                file1.add(i,"");
            }
            file2.add(file2.size(),"");
        }
        else{
            plus=file1.size()+1;
            for (int i = file2.size(); i <plus ; i++)
            {
                file2.add(i,"");
            }
            file1.add(file1.size(),"");
        }

        for (int i = 0; i <file1.size() ; i++)
        {
            try
            {
                if (file1.get(i).equals(file2.get(i)))
                {
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    file1.remove(i);
                    file2.remove(i);
                    i--;

                } else
                {
                    if (file1.get(i + 1).equals(file2.get(i)) && !file1.get(i).equals(file2.get(i + 1)))
                    {
                        lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                        file1.remove(i);
                        i--;
                    } else
                    {
                        if (file1.get(i).equals(file2.get(i + 1)) || !file1.get(i).equals(""))
                        {
                            lines.add(new LineItem(Type.ADDED, file2.get(i)));
                            file2.remove(i);
                            i--;
                        }
                    }
                }

            }
            catch(IndexOutOfBoundsException e){
                //System.out.println("+++++");
                if (file1.get(i).equals(""))
                {
                    for (int j = i; j < file2.size(); j++)
                    {
                        lines.add(new LineItem(Type.ADDED, file2.get(j)));
                    }
                    break;
                }

                if (file2.get(i).equals(""))
                {
                    for (int j = i; j < file1.size(); j++)
                    {
                        lines.add(new LineItem(Type.REMOVED, file2.get(j)));
                    }
                    break;
                }
            }
        }

        for (int i = lines.size()-1; i >=0 ; i--)
        {
            if (lines.get(i).line.equals("")) lines.remove(i);
        }
        for (LineItem line:lines)
        {
            System.out.println(line.type+" "+line.line);
        }
    }



    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
