package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution
{
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    /*class Thread1 extends Thread{

        @Override
        public void run()
        {
            while (true){

            }
        }
    }

   class Thread2 extends Thread{

       @Override
       public void run()
       {
           try
           {
               if (isInterrupted()) throw new InterruptedException();

           }
           catch (InterruptedException i){
               System.out.println("InterruptedException");
           }
       }
   }

   class Thread3  extends Thread {

       @Override
       public void run()
       {
           while (true){
               try
               {
                   Thread.sleep(500);
                   System.out.println("Ура");
               }
               catch (InterruptedException e)
               {
                   e.printStackTrace();
               }

           }
       }
   }

   class Thread4 extends Thread implements Message{


       @Override
       public  void run()
       {
           while (!isInterrupted()) {}
       }

       @Override
       public void showWarning()
       {

           try
           {
               this.interrupted();
               this.join();
           }
           catch (InterruptedException e)
           {
               e.printStackTrace();
           }
       }
   }*/
    public static class Thread1 extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {
            }
        }
    }

    public static class Thread2 extends Thread
    {
        public void run()
        {
            try
            {
                while (!isInterrupted())
                {
                }
                throw new InterruptedException();
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {
                System.out.println("Ура");
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message
    {
        @Override
        public void showWarning()
        {
            this.interrupt();
            try
            {
                this.join();
            }
            catch (InterruptedException e)
            {
            }
        }

        @Override
        public void run()
        {
            while (!Thread.currentThread().isInterrupted())
            {
            }
        }
    }


    public static class Thread5 extends Thread
    {
        int sum;
        String key;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        @Override
        public void run()
        {
            try
            {
                while (!(key = reader.readLine()).equals("N"))
                    sum = sum + Integer.parseInt(key);
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.println(sum);
        }
    }
}
