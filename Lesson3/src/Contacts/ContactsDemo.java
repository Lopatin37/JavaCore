package Contacts;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactsDemo
{
    public static void main(String[] args) throws WrongAddingException, WrongSearchingException
    {

        MyContacts contacts = new MyContacts();
        contacts.add("Lopatin", "89998410558");
        contacts.add("Petrov", "89108221258");
        contacts.add("Ivanov", "89156782873");

        //Далее вызываются методы, который выбрасывают исключения.
        contacts.add("Lopatin", "89154402931");
        contacts.add("Sidorov", "8960590812");
        contacts.get("Grigorev");
        System.out.println(contacts.getContacts());


    }



}
