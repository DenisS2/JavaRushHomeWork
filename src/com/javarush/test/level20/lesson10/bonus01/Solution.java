package com.javarush.test.level20.lesson10.bonus01;

import java.util.*;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
    /*public static void main(String[] args)
    {
        long a = System.currentTimeMillis();
        int[] result = getNumbers(146511208);
        long b = System.currentTimeMillis();
        System.out.println("Time + " + (b - a)+" ms   "+(b - a)/1000+" s");
        long usedBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedBytes / (1024 * 1024));
        for (int i:result)
        {
            System.out.print(i+" ");
        }

    }*/

    public static int[] getNumbers(int N)
    {
        int[] result=null;
        List<Integer> list = new ArrayList<>();
        for (int n = 1; n < N; n++)
        {
            int sum = 0;
            int r;
            int temp = n;
            int length = (int) (Math.log10(n) + 1);
            while (temp != 0)
            {
                for (int i = 0; i < length; i++)
                {
                    int prod = 1;
                    r = temp % 10;
                    for (int j = 0; j < length; j++)
                    {
                        prod = prod * r;
                    }
                    sum = sum + prod;
                    temp = temp / 10;
                }
            }
            if (n == sum)
            {
                list.add(n);
            }
        }

        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }
}
