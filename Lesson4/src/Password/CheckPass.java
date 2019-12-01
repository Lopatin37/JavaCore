package Password;

import java.util.regex.*;



public class CheckPass
{
    public static void main(String[] args) throws MyException
    {
        Pattern pat = Pattern.compile("\\s");
        Matcher mat = pat.matcher("asdasdsadas2daWs");
        try
        {
            if(mat.find()) throw new MyException("There is a space key.");
            Pattern pat1 = Pattern.compile("([A-Z]+[a-z]+[0-9]+)|([A-Z]+[0-9]+[a-z]+)|([a-z]+[A-Z]+[0-9]+)|([a-z]+[0-9]+[A-Z]+)|([0-9]+[A-Z]+[a-z]+)|([0-9]+[a-z]+[A-Z]+)");
            Matcher mat1 = pat1.matcher("asdasdsadas2daWs");
            if(mat1.find()) System.out.println("The password is safe.");
        }catch(MyException e)
        {
            System.out.println(e.cause);
        }


    }
}
