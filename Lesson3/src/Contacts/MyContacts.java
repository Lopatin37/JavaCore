package Contacts;

import java.util.ArrayList;
import java.util.HashMap;

public class MyContacts
{
    private HashMap<String, ArrayList<String>> contacts;

    MyContacts()
    {
        this.contacts = new HashMap<>();
    }
    HashMap<String, ArrayList<String>> getContacts()
    {
        HashMap<String, ArrayList<String>> copy = new HashMap<String, ArrayList<String>>(contacts);
        return copy;
    }

    void get(String name) throws WrongSearchingException
    {
        try
        {
            if (!contacts.containsKey(name)) throw new WrongSearchingException("Контакт " + name + " не обнаружен.");
            System.out.println(name + ": " + this.contacts.get(name));
        }catch (WrongSearchingException e)
        {

        }
    }

    void add(String name, String phoneNumber) throws WrongAddingException
    {
        try
        {
            if (contacts.containsKey(name)) throw new WrongAddingException("Контакт " + name + " уже существует. Новый номер будет добавлен к существующему контакту.");
            ArrayList<String> number = new ArrayList<String>();
            number.add(phoneNumber);
            this.contacts.put(name, number);
        }catch (WrongAddingException e)
        {
            ArrayList<String> number = contacts.get(name);
            number.add(phoneNumber);
            contacts.put(name, number);
        }
    }
//
}
