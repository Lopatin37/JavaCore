package Exception;

public class MyArr
{

    static void toIntAndSum (String[][]arr) throws MyArraySizeException, MyArrayDataException
    {
        try
        {
            if (arr.length != 4) throw new MyArraySizeException();
            for (int i = 0; i < 4; i++) {if (arr[i].length != 4) throw new MyArraySizeException();}
            int sum = 0;
            for (int i = 0; i < arr.length; i++)
            {
                for (int j = 0; j < arr[i].length; j++)
                {
                    //в следующей строке String преобразуется в char[]
                   char[] c = arr[i][j].toCharArray();
                   //В следующей строке проверяется, является ли char[l] числом
                   for(int l = 0; l < c.length; l++) {if(!Character.isDigit(c[l])) throw new MyArrayDataException(i, j);}
                   sum += Integer.parseInt(arr[i][j]);
                }
            }
            System.out.println("Сумма всех элементов: " + sum);
        }catch(MyArraySizeException e)
        {
            System.out.println("Перехвачено исключение:" + e);
            e.printStackTrace();
        }
        catch(MyArrayDataException e)
        {
            System.out.println("Перехвачено исключение:" + e);
            e.printStackTrace();
        }
    }
}
