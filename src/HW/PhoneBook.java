package HW;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public static HashMap<String, String> phonebook = new HashMap<String, String>();

    public static void newNum(String phone, String name) {
        phonebook.put(phone, name);
    }

    public static void delNum(String phone) {
        phonebook.remove(phone);
    }

    public static void saveNum() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("PhoneBook.txt")));
        for(Map.Entry<String,String> k: phonebook.entrySet()){
            writer.write(k.getKey() + " " + k.getValue()+System.lineSeparator());
        }
        writer.close();
    }

    public static void listNum() throws IOException {
        File file = new File("PhoneBook.txt");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("PhoneBook.txt")));
            String act;
            while ((act=reader.readLine())!=null) {
                String[] dat = act.split(" ");
                phonebook.put(dat[0], dat[1]);
            }
            reader.close();
        }
    }

    public static void ShowNum(){
        System.out.println("Телефонный справочник: ");
        for(Map.Entry<String,String> k: phonebook.entrySet()){
            System.out.println(k.getValue()+": "+ k.getKey());
        }
    }

    public static String[] searchNum(String surname){
        List <String> result = new ArrayList<String>();
        for (Map.Entry entry : phonebook.entrySet()) {
            if (surname.equalsIgnoreCase((String)entry.getValue())){
                result.add((String)entry.getKey());
            }
        }
        if (result.size() == 0) result.add("контакт не найден");
        return result.toArray(new String[0]);
    }
}