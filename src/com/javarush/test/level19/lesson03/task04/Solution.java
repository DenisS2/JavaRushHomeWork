package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner sc;

        public PersonScannerAdapter(Scanner scanner)
        {
            sc=scanner;
        }

        @Override
        public Person read() throws IOException
        {

            String str = sc.nextLine();
            String[] s=str.split(" ");
            /*Date date = new Date();
            date.setDate(Integer.parseInt(s[3]));
            date.setMonth(Integer.parseInt(s[4]));
            date.setYear(Integer.parseInt(s[5]));*/
            Calendar calendar = new GregorianCalendar(Integer.parseInt(s[5]), Integer.parseInt(s[4]) - 1, Integer.parseInt(s[3]));
            Date date = calendar.getTime();
            Person person= new Person(s[1],s[2],s[0],date);

            return person;
        }

        @Override
        public void close() throws IOException
        {
            sc.close();
        }
    }
}
