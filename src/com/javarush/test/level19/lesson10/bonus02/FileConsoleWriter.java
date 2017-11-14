package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;


public class FileConsoleWriter extends FileWriter
{

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);

    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }


    @Override
    public void write(int c) throws IOException
    {
        System.out.print((char) c);
        super.write(c);
    }

    @Override
    public void write(char[] cbuf) throws IOException
    {
       // for (int i = 0; i < cbuf.length; i++)
       // {
       //     System.out.println(cbuf[i]);
       // }
        super.write(cbuf);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        for (int i = off; i <off+len ; i++)
        {
            System.out.print(cbuf[i]);
        }
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str) throws IOException
    {
        //System.out.println(str);
        super.write(str);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        System.out.println(str.substring(off,off+len));
        super.write(str, off, len);
    }


}

/*class  test{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String fileName1 ="D://1.txt";//br.readLine();
        String fileName2 ="D://2.txt";//br.readLine();//"D://2.txt";//=
        br.close();

        FileReader reader = new FileReader(fileName1);
        FileWriter writer = new FileConsoleWriter(fileName2);

        char [] data= new char[1000];


        while (reader.ready())
        {
            int count = reader.read(data);

                 writer.write(data);

        }
        reader.close();
        writer.close();
    }}*/