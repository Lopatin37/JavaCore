package Password;

public class MyException extends Exception
{
    String cause;
    public MyException(String str)
    {
        cause = str;
    }
}
