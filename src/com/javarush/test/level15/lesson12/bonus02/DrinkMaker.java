package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by User on 06.01.2017.
 */
abstract public class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
        }
}
