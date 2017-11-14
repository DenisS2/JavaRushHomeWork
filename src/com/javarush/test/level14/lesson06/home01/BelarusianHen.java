package com.javarush.test.level14.lesson06.home01;

/**
 * Created by User on 03.01.2017.
 */
public class BelarusianHen extends Hen
{
    String getDescription()
    {

        return super.getDescription()  + " Моя страна - "+Country.BELARUS +". Я несу "+ getCountOfEggsPerMonth()+" яиц в месяц.";
    }
    @Override
    int getCountOfEggsPerMonth()
    {

        return 20;
    }
}
