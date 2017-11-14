package com.javarush.test.level14.lesson06.home01;

/**
 * Created by User on 03.01.2017.
 */
public abstract class Hen
{
   // int countOfEggsPerMonth;
    abstract int getCountOfEggsPerMonth();
    String getDescription()
    {
        return "Я курица.";
    }
}
