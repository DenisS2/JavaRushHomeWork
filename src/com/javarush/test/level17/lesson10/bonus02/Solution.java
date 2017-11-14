package com.javarush.test.level17.lesson10.bonus02;

import com.javarush.test.level17.lesson10.bonus01.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран
в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
     public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0])
        {
            case "-c":{
                int length=args.length-1;
                length=length/3;
                int j=0;
                for (int i = 0; i <length ; i++)
                {
                addPerson(args[1+j],args[2+j], args[3+j]);
                j=j+3;
                }
                break;
            }
            case "-u":{
                int length=args.length-1;
                length=length/4;
                int j=0;
                for (int i = 0; i <length ; i++)
                {
                    updatePerson(args[1+j], args[2+j], args[3+j], args[4+j]);
                    j=j+4;
                }
                break;
            }
            case "-d":{
                int length=args.length-1;
                for (int i = 0; i <length ; i++)
                {
                    deletePerson(args[1+i]);
                }
                break;
            }
            case "-i":
            {
                int length = args.length-1;
                for (int i = 0; i < length; i++)
                {
                    infoPerson(args[1+i]);
                }
                break;
            }
            default:{
                System.out.println("Неверный 1-й параметр"); break;}
        }
    }

    static synchronized void addPerson(String name,String sex,String birthday)
    {
        Date bd = formatDate(birthday);
        int id=allPeople.size();
        switch (sex)
        {
            case "м":{
                allPeople.add(id, Person.createMale(name, bd));
                System.out.println(id);
                break;
            }
            case "ж":{
                allPeople.add(id, Person.createFemale(name, bd));
                System.out.println(id);
                break;
            }
            default:{
                System.out.println("Неверный пол м/ж"); break;}
        }
    }

    static synchronized void updatePerson(String index,String name,String sex,String birthday)
    {
        Date bd = formatDate(birthday);
        int id=Integer.parseInt(index);
        if (id>allPeople.size()){
            System.out.println("нет такого id");
            System.exit(0);
        }
        switch (sex)
        {
            case "м":{
                allPeople.set(id, Person.createMale(name, bd));
                break;
            }
            case "ж":{
                allPeople.set(id, Person.createFemale(name, bd));
                break;
            }
            default:{
                System.out.println("Неверный пол м/ж");
                System.exit(0);
                break;
            }
        }
    }

    static synchronized void deletePerson(String index){
        int id=Integer.parseInt(index);
        if (id>=allPeople.size()){
            System.out.println("нет такого id");
            System.exit(0);
        }
        allPeople.set(id, null);
    }

    static  void infoPerson(String index){
        int id=Integer.parseInt(index);
        if (id>=allPeople.size()){
            System.out.println("нет такого id");
            System.exit(0);
        }
        char sex='?';
        Person person = allPeople.get(id);
        if (person.getSex().equals(Sex.MALE)) sex='м';
        if (person.getSex().equals(Sex.FEMALE)) sex='ж';
        System.out.println(person.getName()+" "+sex+" "+formatDate(person.getBirthDay()));
    }

    static synchronized Date formatDate(String d){

        Date date= null;
        try
        {
            date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(d);
            //System.out.println(date);
            return date;
        }
        catch (ParseException e)
        {
            System.out.println("Неправильный формат даты dd/mm/yyyy");
            System.exit(0);
        }
        System.out.println(date);
        return date;
    }

    static synchronized String formatDate(Date d){
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String date = format.format(d);
        return date;
    }
}
