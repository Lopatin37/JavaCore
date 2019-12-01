public class CallerChange implements Runnable
{
    float[] array;

    ChangeArray chAr;
    Thread t;

    public CallerChange(float[] arr, ChangeArray change)
    {
        array = arr;
        t = new Thread(this);
        chAr = change;
        t.start();
    }
    @Override
    public void run()
    {
//        synchronized (chAr)
//        {
            array = chAr.change(array);
//        }
    }
}
