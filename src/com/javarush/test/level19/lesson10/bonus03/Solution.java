package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег,
одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String fileName =  br.readLine(); //"d://4.html";
        br.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String tag=args[0];
        String line="";
        String result;
        while (fileReader.ready())
        {
             line=line+fileReader.readLine();
        }
        fileReader.close();

        for (int i=0; i<line.length();i++)
        {
            int countTeg=0;
            int tagStart = line.indexOf("<" + tag, i);
            if (tagStart<0) break;
            i=tagStart;
            int tagEnd = line.indexOf("</" + tag, tagStart);
            if (tagEnd < 0) tagEnd = line.length()-1;
            result=line.substring(tagStart,tagEnd)+"</"+tag+">";
            if (result.indexOf("<" + tag,1)>0)
            {
                for (int j = 1; j < result.length(); j++)
                {
                    int subTag = result.indexOf("<" + tag, j);
                    if (subTag < 0) break;
                    countTeg++;
                    j = subTag;
                }
                if (countTeg != 0)
                {
                    for (int j = 0; j < countTeg; j++)
                    {
                        tagEnd = line.indexOf("</" + tag, tagEnd+1);
                    }
                    result = line.substring(tagStart, tagEnd) + "</" + tag + ">";
                }
            }
            
            System.out.println(result);
        }
        //for (String s:file)
        //{
        //    System.out.println(s);
        //}
    }
}
