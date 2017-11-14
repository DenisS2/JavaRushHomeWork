package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
        public A(){}
    }

    public  class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {

            out.writeObject(name);

        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

            name=(String) in.readObject();

        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution solution = new Solution();
        Solution.B b = solution.new B("hh");
        FileOutputStream fileOutput = new FileOutputStream("d://cat.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(b);
        fileOutput.close();
        outputStream.close();

        //load cat from file
        FileInputStream fiStream = new FileInputStream("d://cat.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object object = objectStream.readObject();
        fiStream.close();
        objectStream.close();

        B newB = (B)object;

        System.out.println(newB.name.equals(b.name));


        /*Solution solution = new Solution();
        Solution.B b = solution.new B("hh");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(b);
        out.flush();
        out.close();
        B b2 = (B) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject();
        System.out.println(b2.name.equals(b.name));*/

    }

}
