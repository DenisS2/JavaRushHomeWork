package com.javarush.test.level18.lesson03.task05;

import java.io.FileInputStream;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream input = new FileInputStream(fileName);
        ArrayList<Integer> file = new ArrayList();
        while (input.available()>0){
            file.add(input.read());
        }
        input.close();
        Collections.sort(file);

        for (int i = file.size()-1; i >0; i--)
        {
            if (file.get(i)==file.get(i-1))file.remove(i);
        }
        for (int i:file)
        {
            System.out.print(i+" ");
        }
    }
}