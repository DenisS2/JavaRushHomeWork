package com.javarush.test.level15.lesson12.home05;

/**
 * Created by User on 05.01.2017.
 */
public class SubSolution extends Solution
{
    public SubSolution()
    {
    }

    public SubSolution(String s)
    {
        super(s);
    }

    public SubSolution(int i)
    {
        super(i);
    }

    protected SubSolution(double d, String s)
    {
        super(d, s);
    }

    protected SubSolution(double d, String s, int i)
    {
        super(d, s, i);
    }

    protected SubSolution(double d, String s, double i)
    {
        super(d, s, i);
    }

    SubSolution(double d, String s, String i)
    {
        super(d, s, i);
    }

     SubSolution(String d, String s, String i)
    {
        super(d, s, i);
    }

    SubSolution(int d, String s, String i)
    {
        super(d, s, i);
    }
    private SubSolution(String s, int i){}
    private SubSolution( int i, String s){}
    private SubSolution(String s, double i){}
}
