package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name",null, new File("d:/test"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            JavaRush javaRush1 = new JavaRush();
            //initialize users field for the javaRush object here -
            // инициализируйте поле users для объекта javaRush тут
            for (int i = 0; i < 5; i++)
            {
                User user = new User();
                user.setFirstName("Ivan"+i);
                user.setLastName("Vasin"+i);
                user.setBirthDate(new Date());
                user.setMale(true);
                user.setCountry(User.Country.RUSSIA);
                javaRush.users.add(user);
            }
            javaRush.save(outputStream);
            javaRush1.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object -
            // проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject))
                System.out.println("Все ОК");
            else System.out.println("что то не то");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            //writer.println("Start");
            String isAssets = users != null ? "yes" : "no";
            writer.println(isAssets);
            writer.println(users.size());
            for (int i = 0; i < users.size(); i++)
            {
                writer.println(users.get(i).getFirstName());
                writer.println(users.get(i).getLastName());
                writer.println(users.get(i).getBirthDate().getTime());
                writer.println(users.get(i).isMale());
                writer.println(users.get(i).getCountry());
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isAssets = reader.readLine();
            if (isAssets.equals("yes"))
            {
                int size=Integer.parseInt(reader.readLine());
                if (size!=0)
                {
                    //JavaRush newJavaRush = new JavaRush();
                    for (int i = 0; i < size; i++)
                    {
                        User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                        user.setMale(Boolean.parseBoolean(reader.readLine()));
                        String coun=reader.readLine();
                        User.Country country;
                        if (coun.equals("null"))
                            country=null;
                        else
                        if (coun.equals("UKRAINE"))
                        {
                            country = User.Country.UKRAINE;
                        }
                        else
                        if (coun.equals("RUSSIA"))
                        {
                            country = User.Country.RUSSIA;
                        }
                            else
                                {
                                    country = User.Country.OTHER;
                                }
                        user.setCountry(country);
                        users.add(user);
                    }
                }
                else new JavaRush();

            }


        }
    }
}
