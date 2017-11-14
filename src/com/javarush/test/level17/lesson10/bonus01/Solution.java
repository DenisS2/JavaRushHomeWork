package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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
            case "-c":{addPerson(args[1],args[2], args[3]); break;}
            case "-u":{updatePerson(args[1],args[2], args[3],args[4]); break;}
            case "-d":{deletePerson(args[1]); break;}
            case "-i":{infoPerson(args[1]); break;}
            default:{
                System.out.println("Неверный 1-й параметр"); break;}
        }
    }

    static void addPerson(String name,String sex,String birthday)
    {
        Date bd = formatDate(birthday);
        int id=allPeople.size();
        switch (sex)
        {
            case "м":{
                allPeople.add(id,Person.createMale(name, bd));
                System.out.println(id);
                break;
            }
            case "ж":{
                allPeople.add(id,Person.createFemale(name, bd));
                System.out.println(id);
                break;
            }
            default:{
                System.out.println("Неверный пол м/ж"); break;}
        }
    }

    static void updatePerson(String index,String name,String sex,String birthday)
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
                allPeople.set(id,Person.createMale(name, bd));
                break;
            }
            case "ж":{
                allPeople.set(id,Person.createFemale(name, bd));
                break;
            }
            default:{
                System.out.println("Неверный пол м/ж");
                System.exit(0);
                break;
            }
        }
    }

    static void deletePerson(String index){
        int id=Integer.parseInt(index);
        if (id>allPeople.size()){
            System.out.println("нет такого id");
            System.exit(0);
        }
        allPeople.set(id, null);
    }

    static void infoPerson(String index){
        int id=Integer.parseInt(index);
        if (id>allPeople.size()){
            System.out.println("нет такого id");
            System.exit(0);
        }
        char sex='?';
        Person person = allPeople.get(id);
        if (person.getSex().equals(Sex.MALE)) sex='м';
        if (person.getSex().equals(Sex.FEMALE)) sex='ж';
        System.out.println(person.getName()+" "+sex+" "+formatDate(person.getBirthDay()));
    }

    static Date formatDate(String d){

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

    static String formatDate(Date d){
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String date = format.format(d);
        return date;
    }
}
