package HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String act;
        PhoneBook.listNum();
        PhoneBook.ShowNum();

        System.out.println("выбор действия( введите цифру):\n " +
                "1 - добавить новый контакт\n " +
                "2 - удалить данные\n " +
                "3 - поиск по имени\n " +
                "0 - выход");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while(!act.equals("0")){
            if(act.equals("1")){
                System.out.println("Введите имя:");
                String name = bf.readLine();
                System.out.println("Введите номер:");
                String phone = bf.readLine();
                PhoneBook.newNum(phone, name);
                PhoneBook.saveNum();
            }else{
                if(act.equals("2")){
                    System.out.println("Введите номер:");
                    String phone = bf.readLine();
                    PhoneBook.delNum(phone);
                    PhoneBook.saveNum();
                }else{
                    if (act.equals("3")){
                        System.out.println("Введите имя:");
                        String surname = bf.readLine();
                        String[] numbers = PhoneBook.searchNum(surname);
                        for (String number : numbers) {
                            System.out.println(number);
                        }
                    }
                }
            }
            System.out.println("выбор действия( введите цифру):\n " +
                    "1 - добавить новый контакт\n " +
                    "2 - удалить данные\n " +
                    "3 - поиск по номеру\n " +
                    "0 - выход");
            act=bf.readLine();
        }
    }

}
