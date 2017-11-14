package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

        Human grangfather1 = new Human("Дед1", true, 80);
        Human grangfather2 = new Human("Дед2", true, 88);
        Human grangmother1 = new Human("Бабка1", false, 70);
        Human grangmother2 = new Human("Бабка2", false, 76);
        Human father = new Human("Отец",true, 35, grangfather1, grangmother1);
        Human mother = new Human("Мать", false, 30, grangfather2, grangmother2);
        Human cildren1 = new Human("Ребенок1", true,10, father, mother);
        Human cildren2 = new Human("Ребенок2", false,7, father, mother);
        Human cildren3 = new Human("Ребенок3", true,10, father, mother);
        System.out.println(grangfather1);
        System.out.println(grangfather2);
        System.out.println(grangmother1);
        System.out.println(grangmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(cildren1);
        System.out.println(cildren2);
        System.out.println(cildren3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;

    }
        public Human (String name, boolean sex, int age){
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

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
