package Contacts;

public class WrongSearchingException extends Exception
{
    public WrongSearchingException(String message)
    {
        System.out.println(message);
    }
}
