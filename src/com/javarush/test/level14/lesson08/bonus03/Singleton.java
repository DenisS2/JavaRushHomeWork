package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by User on 04.01.2017.
 */
public class Singleton {
    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton == null ){
            singleton = new Singleton();
        }
        return singleton;
    }
}