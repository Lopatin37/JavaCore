package Array;

public class MyArrayDemo
{
    public static void main(String[] args)
    {
        MyArray arr = new MyArray("Dima", "Petr", "Sergey", "Alex", "Evgeniy", "Sergey", "Anton", "Artem", "Nail", "Alex", "Sergey", "Ruslan", "Konstantin", "Kirill", "Leonid", "Dima");
        //arr.printArr() - выводит массив полностью
        //arr.printArr();
        //arr.printUnique() - вывод фамилии без дублирования
        //arr.printUnique();
        //arr.wordCount() - считает количество повторений имен в массиве
        arr.wordCount();
    }
}
