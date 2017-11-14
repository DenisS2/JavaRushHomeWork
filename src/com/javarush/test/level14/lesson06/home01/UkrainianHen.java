package com.javarush.test.level14.lesson06.home01;

/**
 * Created by User on 03.01.2017.
 */
public class UkrainianHen extends Hen
{
    String getDescription()
    {
        return super.getDescription()  + " Моя страна - "+Country.UKRAINE +". Я несу "+ getCountOfEggsPerMonth()+" яиц в месяц.";
    }
    @Override
    int getCountOfEggsPerMonth()
    {
        return 15;
    }
}
