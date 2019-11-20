package Exception;

public class MyExceptionDemo
{
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException
    {
            String[][] str = new String[4][4];


//          Передача строки с неверной размерностью
////        String[][] str = new String[2][4];
//          String[][] str = new String[4][3];


            for(int i = 0; i < str.length; i++)
                for(int j = 0; j < str[i].length; j++)
                    str[i][j] = "10";


//          Передача в одной ячейке строки, которую нельзя преобразовать в int
//          str[2][3] = "10a";


            MyArr.toIntAndSum(str);
    }
}
