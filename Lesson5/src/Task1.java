public class Task1
{
    static final int SIZE = 10000000;
    public static void change()
    {
        float[] array = new float[SIZE];
        for(int i = 0; i < SIZE; i++)
            array[i] = 1;
        long a = System.currentTimeMillis();
        for(int i = 0; i < SIZE; i++)
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.out.println("Время выполнения задания с использованием одного потока: " +
                            (System.currentTimeMillis() - a) + " мс.");
//        System.out.println(array[1000] + " " + array[5000000]);
    }
}
