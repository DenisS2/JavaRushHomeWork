package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/



public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        //char[] chArray = s.toCharArray();
        //System.out.println(chArray.length);
        for (int i = 0; i <40 ; i++)
        {
            //System.out.println(s);
            System.out.println(s.substring(i));

            /*for (int j = 0; j <chArray.length-1 ; j++)
            {
                chArray[j] = chArray[j + 1];

                chArray[chArray.length-1]=' ';
            }*/

        }
        /*for (int i = 0; i <s.length() ; i++)
        {
            list.add(s.charAt(i));
        }
        for (int i = 0; i < 40; i++)
        {
            System.out.println(list.toString());
            //c=list.get(0);
            list.remove(0);
        }*/

    }

}
