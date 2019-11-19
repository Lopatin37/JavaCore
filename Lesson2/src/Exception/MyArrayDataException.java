package Exception;

class MyArrayDataException extends Exception
{
    MyArrayDataException(int i, int j)
    {
        System.out.println("В ячейке [" + i +"][" + j + "] невозможно преобразование в целое число.");
    }
}
