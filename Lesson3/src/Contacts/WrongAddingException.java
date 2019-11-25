package Contacts;

import java.util.ArrayList;

public class WrongAddingException extends Exception
{
    public WrongAddingException(String message)
    {
        System.out.println(message);
    }
}
