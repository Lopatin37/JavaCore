package Array;

import java.util.ArrayList;

public class MyArray
{
    private int defaultSize = 10;
    private String[] words = new String[defaultSize];
    private int index = 0;
//    ArrayList<String>words = new ArrayList<>();
//    public MyArray(String...arrOfWords)
//    {
//        for(String word : arrOfWords)
//            this.words.add(word);
//    }
//
//    void printArray
    public MyArray(String...arr)
    {
        for(String newWord : arr)
        {
            if(index < words.length)
            {
                words[index] = newWord;
                index++;
            }else
            {
                String[] newArr = new String[words.length * 2];
                for(int i = 0; i < words.length; i++) {newArr[i] = words[i];}
                words = newArr;
                words[index] = newWord;
                index++;
            }
        }
    }

    void printArr()
    {
        for (int i = 0; i < words.length; i++)
            if(words[i] != null) System.out.println(words[i] + " ");
    }
    void printUnique()
    {
        boolean isUnique = true;
        for(int i = 0; i < words.length; i++)
        {
            for(int j = i + 1; j < words.length; j ++)
                if (words[i] == words[j]) isUnique = false;

            if(isUnique && words[i] != null)
                System.out.print(words[i] + " ");
            else isUnique = true;
        }
        System.out.println();
    }

    void wordCount()
    {
        int num;
        for(int i = 0; i < words.length; i ++)
        {
            if(words[i] == null) continue;
            num = 1;
            if(words[i] != null)
                for(int j = i + 1; j < words.length; j ++)
                    if(words[i] == words[j])
                    {
                        num++;
                        words[j] = null;
                    }
            System.out.println(words[i] + " - " + num + " раз.");
        }
    }
}
