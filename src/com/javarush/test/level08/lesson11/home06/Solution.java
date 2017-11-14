package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> childrenList = new ArrayList<Human>();
        ArrayList<Human> motherList =new ArrayList<Human>();
        ArrayList<Human> fatherList = new ArrayList<Human>();
        ArrayList<Human> clear =new ArrayList<Human>();


        Human grandfather1= new Human("Ivan", true,88, fatherList);
        Human grandfather2= new Human("Petr", true,90, fatherList);
        Human grandmother1= new Human("Ira", false,80, motherList);
        Human grandmother2= new Human("Masha", false,81, motherList);
        Human father= new Human("Dima", true,35, childrenList);
        Human mother= new Human("Olesy", false,30, childrenList);
        Human children1= new Human("Sveta", false,10, clear);
        Human children2= new Human("Andrey", true,2, clear);
        Human children3= new Human("Anna", false,5, clear);
        childrenList.add(children1);
        childrenList.add(children2);
        childrenList.add(children3);
        motherList.add(mother);
        fatherList.add(father);
        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
    {
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.children =children;


    }

        public Human(String name, boolean sex, int age)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;



        }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
