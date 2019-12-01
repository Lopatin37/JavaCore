public class Task3
{
    static final int SIZE = 10000000;
    static int threadNum = 2;
    static final int H = SIZE/threadNum;
    static int index = 0;


    static float[] subArr(float[] array)
    {
        float[] a1 = new float[H];
        System.arraycopy(array, index, a1, index, H);
        index += H;
        return a1;
    }


    public static void change()
    {

        float[] array = new float[SIZE];
        float[][] arr = new float[threadNum][H];
//        float[] a1 = new float[H];
//        float[] a2 = new float[H];
        for(int i = 0; i < SIZE; i++)
            array[i] = 1;

        long a = System.currentTimeMillis();
//        System.arraycopy(array, 0, a1, 0, H);
//        System.arraycopy(array, H, a2, 0, H);

        ChangeArray ch = new ChangeArray();
        for(int i = 0; i < threadNum; i++)
        {
            for(int j = 0; j < H; j++)
            {

            }
        }
//        ChangeArray ch = new ChangeArray();
        CallerChange ob1 = new CallerChange(a1, ch);
        CallerChange ob2 = new CallerChange(a2, ch);
        try
        {
            ob1.t.join();
            ob2.t.join();
        }catch (InterruptedException e)
        {
            System.out.println("Прервано.");
        }
        System.arraycopy(a1, 0, array, 0, H);
        System.arraycopy(a2, 0, array, H, H);
        System.out.println("Время выполнения задания с использованием двух потоков: " +
                (System.currentTimeMillis() - a) + " мс.");
//        System.out.println(a1[1000] + " " + array[1000] + " " + a2[0] + " " + array[5000000]);
    }
}
