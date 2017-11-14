package com.javarush.test.level16.lesson10.task02;

/* Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с countSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].
Пример для countSeconds=4 : [4 3 2 1 Прервано!]
4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для countSeconds=3 : [3 2 1 Марш!]
PS: метод sleep выбрасывает InterruptedException.
*/

import java.util.ArrayList;

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        double time=0;
        while (true)
        {
            Thread.sleep(100);
            time=time+0.1;
            if (time>=3.5)
            {   clock.interrupt();
                break;
            }
        }

    }

    public static class RacingClock extends Thread
    {
        public RacingClock()
        {
            start();
        }

        public void run()
        {
            //add your code here - добавь код тут

            try
            {

                    while (countSeconds> 0)
                    {

                        System.out.print(countSeconds + " ");
                        Thread.sleep(1000);
                        countSeconds--;
                    }
                System.out.print("Марш!");
            }
            catch (InterruptedException e)
            {
                System.out.println("Прервано!");
            }

        }
    }
}
