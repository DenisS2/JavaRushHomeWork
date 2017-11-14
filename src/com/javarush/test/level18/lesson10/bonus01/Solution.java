package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        switch (args[0])
        {
            case "-e":
                encription(args);
                break;
            case "-d":
                decription(args);
                break;
            default:
                System.out.println("Неправильный ключ " + args[0]);
                break;
        }

    }

    static void encription(String[] args) throws IOException
    {
        FileInputStream input = new FileInputStream(args[1]);
        byte[] buffer = new byte[input.available()];
        input.read(buffer);
        input.close();
        for (int i = 0; i <buffer.length ; i++)
        {
            if (buffer[i]<125)buffer[i]+=3;
            else {
                buffer[i]-=125;
            }
        }
        FileOutputStream output = new FileOutputStream(args[2]);
        for (int i = buffer.length-1; i >=0 ; i--)
        {
            int b=(int) buffer[i];
            output.write(b);
        }
        output.close();
    }
    static void decription(String[] args) throws IOException
    {
        FileInputStream input = new FileInputStream(args[1]);
        byte[] buffer = new byte[input.available()];
        input.read(buffer);
        input.close();
        for (int i = 0; i <buffer.length ; i++)
        {
            if (buffer[i]>=3)buffer[i]-=3;
            else {
                buffer[i]+=125;
            }
        }
        FileOutputStream output = new FileOutputStream(args[2]);
        for (int i = buffer.length-1; i >=0 ; i--)
        {
            int b=(int) buffer[i];
            output.write(b);
        }
        output.close();
    }
}

